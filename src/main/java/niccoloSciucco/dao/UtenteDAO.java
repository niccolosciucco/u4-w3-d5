package niccoloSciucco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import niccoloSciucco.entities.Utente;
import niccoloSciucco.exceptions.NotFoundException;
import niccoloSciucco.exceptions.SaveException;

import java.util.List;

public class UtenteDAO {
    private final EntityManager entityManager;

    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Utente newUtente) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newUtente);
            transaction.commit();
            System.out.println("'" + newUtente.getNome() + " " + newUtente.getCognome() + "', è stato aggiunto correttamente");
        } catch (SaveException ex) {
            throw new SaveException("Impossibile aggiungere '" + newUtente.getNome() + " " + newUtente.getCognome() + "'. Problema: " + ex.getMessage());
        }
    }

    public Utente findByTessera(String tessera) {
        try {
            TypedQuery<Utente> query = entityManager.createQuery("SELECT c FROM Utente c WHERE LOWER(c.numeroTessera) LIKE LOWER(:tessera)", Utente.class);
            query.setParameter("tessera", tessera);

            List<Utente> utente = query.getResultList();
            if (utente.isEmpty()) {
                throw new NotFoundException("Nessun utente trovato anno tessera: " + tessera);
            }

            return utente.get(0);

        } catch (NotFoundException ex) {
            throw new NotFoundException("Impossibile trovare utenti con tessera: " + tessera + ". Problema: " + ex.getMessage());
        }
    }
}
