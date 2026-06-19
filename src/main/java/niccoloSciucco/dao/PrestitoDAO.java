package niccoloSciucco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import niccoloSciucco.entities.Catalogo;
import niccoloSciucco.entities.Prestito;
import niccoloSciucco.exceptions.NotFoundException;
import niccoloSciucco.exceptions.SaveException;

import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager entityManager;

    public PrestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Prestito newPrestito) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newPrestito);
            transaction.commit();
            System.out.println("Il prestito dell'utente '" + newPrestito.getUtente() + "' è stato aggiunto correttamente");
        } catch (SaveException ex) {
            throw new SaveException("Impossibile aggiungere il prestito dell'utente '" + newPrestito.getUtente() + "'. Problema: " + ex.getMessage());
        }
    }

    public List<Catalogo> findElementiInPrestito(String numeroTessera) {
        try {
            TypedQuery<Catalogo> query = entityManager.createQuery("SELECT p.catalogo FROM Prestito p " + "WHERE LOWER(p.utente.numeroTessera) = LOWER(:tessera) " + "AND p.dataRestituzioneEffettiva IS NULL", Catalogo.class);
            query.setParameter("tessera", numeroTessera);

            return query.getResultList();

        } catch (NotFoundException ex) {
            throw new NotFoundException("Impossibile recuperare gli elementi del catalogo in prestito per la tessera: " + numeroTessera + ". Problema: " + ex.getMessage());
        }
    }

    public List<Prestito> findPrestitiScaduti(LocalDate now) {
        try {
            TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p " + "WHERE p.dataRestituzioneEffettiva IS NULL " + "AND p.dataResitutzionePrevista < :oggi", Prestito.class);
            query.setParameter("oggi", now);

            return query.getResultList();

        } catch (NotFoundException ex) {
            throw new NotFoundException("Impossibile recuperare la lista dei prestiti scaduti. Problema: " + ex.getMessage());
        }
    }
}
