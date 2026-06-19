package niccoloSciucco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import niccoloSciucco.entities.Catalogo;
import niccoloSciucco.exceptions.DeleteException;
import niccoloSciucco.exceptions.NotFoundException;
import niccoloSciucco.exceptions.SaveException;

import java.util.List;

public class CatalogoDAO {
    private final EntityManager entityManager;

    public CatalogoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Catalogo newElemento) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newElemento);
            transaction.commit();
            System.out.println("'" + newElemento.getTitolo() + "' è stato aggiunto correttamente del Catalogo");
        } catch (Exception ex) {
            throw new SaveException("Impossibile aggiungere al catalogo '" + newElemento.getTitolo() + "'. Problema: " + ex.getMessage());
        }
    }

    public Catalogo findByIsbn(String isbn) {
        try {
            TypedQuery<Catalogo> query = entityManager.createQuery("SELECT c FROM Catalogo c WHERE c.codiceISBN = :isbn", Catalogo.class);
            query.setParameter("isbn", isbn);

            List<Catalogo> risultato = query.getResultList();

            if (risultato.isEmpty()) {
                throw new NotFoundException("Nessun elemento trovato nel catalogo con codice ISBN: " + isbn);
            }

            return risultato.get(0);

        } catch (NotFoundException ex) {
            throw new NotFoundException("Impossibile trovare elemento nel catalogo con codice ISBN: " + isbn + ". Problema: " + ex.getMessage());
        }
    }

    public void deleteByIsbn(String isbn) {
        Catalogo elementoTrovato = findByIsbn(isbn);
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(elementoTrovato);
            transaction.commit();
            System.out.println("'" + elementoTrovato.getTitolo() + "' è stato rimosso correttamente dal Catalogo");
        } catch (Exception ex) {
            throw new DeleteException("Impossibile rimuovere dal catalogo l'elemento con ISBN: " + isbn + ". Problema: " + ex.getMessage());
        }
    }
}
