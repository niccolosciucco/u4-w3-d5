package niccoloSciucco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import niccoloSciucco.dao.CatalogoDAO;
import niccoloSciucco.entities.Libro;
import niccoloSciucco.entities.Rivista;
import niccoloSciucco.enums.Genere;
import niccoloSciucco.enums.Periodicita;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4-w3-d5");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CatalogoDAO catalogoDAO = new CatalogoDAO(entityManager);

        //region CREAZIONE E SALVATAGGIO LIBRI

        //Creazione Libri
        Libro l1 = new Libro("32978-92378", "Il Nome della Rosa", 1980, 503, "Umberto Eco", Genere.AVVENTURA.GIALLO);
        Libro l2 = new Libro("89726746-23981", "Il Signore degli Anelli", 1954, 1216, "J.R.R. Tolkien", Genere.FANTASY);
        Libro l3 = new Libro("103976-238652", "1984", 1949, 336, "George Orwell", Genere.FANTASCIENZA);
        Libro l4 = new Libro("098-28937-23", "Il fu Mattia Pascal", 1904, 256, "Luigi Pirandello", Genere.CLASSICO);
        Libro l5 = new Libro("978-8811810421", "La Coscienza di Zeno", 1923, 432, "Italo Svevo", Genere.CLASSICO);
        Libro l6 = new Libro("75657-09798", "Cronache del Ghiaccio e del Fuoco", 1996, 832, "George R.R. Martin", Genere.FANTASY);
        Libro l7 = new Libro("7658679-0989876", "Cecità", 1995, 276, "José Saramago", Genere.ROMANZO);
        Libro l8 = new Libro("675-987342", "Harry Potter e la Pietra Filosofale", 1997, 304, "J.K. Rowling", Genere.FANTASY);
        Libro l9 = new Libro("453-87", "Fondazione", 1951, 318, "Isaac Asimov", Genere.FANTASCIENZA);
        Libro l10 = new Libro("47658-976674", "Il grande Gatsby", 1925, 180, "F. Scott Fitzgerald", Genere.ROMANZO);

//        try {
//            catalogoDAO.save(l1);
//            catalogoDAO.save(l2);
//            catalogoDAO.save(l3);
//            catalogoDAO.save(l4);
//            catalogoDAO.save(l5);
//            catalogoDAO.save(l6);
//            catalogoDAO.save(l7);
//            catalogoDAO.save(l8);
//            catalogoDAO.save(l9);
//            catalogoDAO.save(l10);
//        } catch (SaveException ex) {
//            System.out.println(ex.getMessage());
//        }

        //endregion

        //region CREAZIONE E SALVATAGGIO RIVISTE

        //Creazione riviste
        Rivista r1 = new Rivista("R-001-A", "National Geographic", 2026, 120, Periodicita.MENSILE);
        Rivista r2 = new Rivista("R-002-B", "Time Magazine", 2026, 64, Periodicita.SETTIMANALE);
        Rivista r3 = new Rivista("R-003-C", "Le Scienze", 2025, 96, Periodicita.MENSILE);
        Rivista r4 = new Rivista("R-004-D", "Focus", 2026, 110, Periodicita.MENSILE);
        Rivista r5 = new Rivista("R-005-E", "Internazionale", 2026, 80, Periodicita.SETTIMANALE);
        Rivista r6 = new Rivista("R-006-F", "Vogue", 2025, 250, Periodicita.MENSILE);
        Rivista r7 = new Rivista("R-007-G", "Harvard Business Review", 2025, 140, Periodicita.SEMESTRALE);
        Rivista r8 = new Rivista("R-008-H", "Wired", 2026, 130, Periodicita.MENSILE);
        Rivista r9 = new Rivista("R-009-I", "The Economist", 2026, 75, Periodicita.SETTIMANALE);
        Rivista r10 = new Rivista("R-010-J", "Psicologia Contemporanea", 2025, 88, Periodicita.SEMESTRALE);

//        try {
//            catalogoDAO.save(r1);
//            catalogoDAO.save(r2);
//            catalogoDAO.save(r3);
//            catalogoDAO.save(r4);
//            catalogoDAO.save(r5);
//            catalogoDAO.save(r6);
//            catalogoDAO.save(r7);
//            catalogoDAO.save(r8);
//            catalogoDAO.save(r9);
//            catalogoDAO.save(r10);
//        } catch (SaveException ex) {
//            System.out.println(ex.getMessage());
//        }

        //endregion

        //region RICERCA TRAMITE ISBN
//        try {
//            Catalogo elementoTrovato = catalogoDAO.findByIsbn("32978-92378");
//            System.out.println("L'elemento ricercato è: '" + elementoTrovato.getTitolo() + "'");
//        } catch (FindException ex) {
//            System.out.println(ex.getMessage());
//        }
        //endregion

        //region RIMOZIONE TRAMITE ISBN
//        try {
//            catalogoDAO.deleteByIsbn("32978-92378");
//        } catch (DeleteException ex) {
//            System.out.println(ex.getMessage());
//        }
        //endregion
    }
}
