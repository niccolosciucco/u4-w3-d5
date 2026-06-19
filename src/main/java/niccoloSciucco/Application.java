package niccoloSciucco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import niccoloSciucco.dao.CatalogoDAO;
import niccoloSciucco.dao.PrestitoDAO;
import niccoloSciucco.dao.UtenteDAO;
import niccoloSciucco.entities.*;
import niccoloSciucco.enums.Genere;
import niccoloSciucco.enums.Periodicita;
import niccoloSciucco.exceptions.NotFoundException;
import niccoloSciucco.exceptions.SaveException;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4-w3-d5");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CatalogoDAO catalogoDAO = new CatalogoDAO(entityManager);
        UtenteDAO utenteDAO = new UtenteDAO(entityManager);
        PrestitoDAO prestitoDAO = new PrestitoDAO(entityManager);

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
        Libro l11 = new Libro("978-8806223412", "Se questo è un uomo", 1947, 178, "Primo Levi", Genere.ROMANZO);

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
//            catalogoDAO.save(l11);
//        } catch (SaveException ex) {
//            System.out.println(ex.getMessage());
//        }

        //endregion

        System.out.println(" ");

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

        System.out.println(" ");

        //region CREAZIONE E SALVATAGGIO UTENTI
        Utente u1 = new Utente("Aldo", "Baglio", LocalDate.of(1958, 9, 28), "TESSERA-ALDO");
        Utente u2 = new Utente("Giovanni", "Storti", LocalDate.of(1957, 2, 20), "TESSERA-GIOV");
        Utente u3 = new Utente("Giacomo", "Poretti", LocalDate.of(1956, 4, 26), "TESSERA-GIACO");
        Utente u4 = new Utente("Christian", "De Sica", LocalDate.of(1951, 1, 5), "TESSERA-DESICA");
        Utente u5 = new Utente("Massimo", "Boldi", LocalDate.of(1945, 7, 23), "TESSERA-BOLDI");
        Utente u6 = new Utente("Checco", "Zalone", LocalDate.of(1977, 6, 3), "TESSERA-CHECO");
        Utente u7 = new Utente("Carlo", "Verdone", LocalDate.of(1950, 11, 17), "TESSERA-VERDONE");
        Utente u8 = new Utente("Lino", "Banfi", LocalDate.of(1936, 7, 9), "TESSERA-BANFI");
        Utente u9 = new Utente("Valerio", "Lundini", LocalDate.of(1986, 3, 11), "TESSERA-LUNDINI");
        Utente u10 = new Utente("Maccio", "Capatonda", LocalDate.of(1978, 8, 9), "TESSERA-MACCIO");

//        try {
//            utenteDAO.save(u1);
//            utenteDAO.save(u2);
//            utenteDAO.save(u3);
//            utenteDAO.save(u4);
//            utenteDAO.save(u5);
//            utenteDAO.save(u6);
//            utenteDAO.save(u7);
//            utenteDAO.save(u8);
//            utenteDAO.save(u9);
//            utenteDAO.save(u10);
//        } catch (SaveException ex) {
//            System.out.println(ex.getMessage());
//        }

        //endregion

        System.out.println(" ");

        //region CREAZIONE E SALVATAGGIO PRESTITI

        try {
            Utente aldo = utenteDAO.findByTessera("TESSERA-ALDO");
            Utente giov = utenteDAO.findByTessera("TESSERA-GIOV");
            Utente giaco = utenteDAO.findByTessera("TESSERA-GIACO");
            Utente desica = utenteDAO.findByTessera("TESSERA-DESICA");
            Utente boldi = utenteDAO.findByTessera("TESSERA-BOLDI");
            Utente checco = utenteDAO.findByTessera("TESSERA-CHECO");
            Utente verdone = utenteDAO.findByTessera("TESSERA-VERDONE");
            Utente banfi = utenteDAO.findByTessera("TESSERA-BANFI");
            Utente lundini = utenteDAO.findByTessera("TESSERA-LUNDINI");
            Utente maccio = utenteDAO.findByTessera("TESSERA-MACCIO");

            Catalogo rosa = catalogoDAO.findByIsbn("32978-92378");
            Catalogo anelli = catalogoDAO.findByIsbn("89726746-23981");
            Catalogo millenove = catalogoDAO.findByIsbn("103976-238652");
            Catalogo pascal = catalogoDAO.findByIsbn("098-28937-23");
            Catalogo zeno = catalogoDAO.findByIsbn("978-8811810421");
            Catalogo ghiaccio = catalogoDAO.findByIsbn("75657-09798");
            Catalogo cecita = catalogoDAO.findByIsbn("7658679-0989876");
            Catalogo harry = catalogoDAO.findByIsbn("675-987342");
            Catalogo fondazione = catalogoDAO.findByIsbn("453-87");
            Catalogo gatsby = catalogoDAO.findByIsbn("47658-976674");

            Catalogo natGeo = catalogoDAO.findByIsbn("R-001-A");
            Catalogo timeMag = catalogoDAO.findByIsbn("R-002-B");
            Catalogo scienze = catalogoDAO.findByIsbn("R-003-C");
            Catalogo focus = catalogoDAO.findByIsbn("R-004-D");
            Catalogo inter = catalogoDAO.findByIsbn("R-005-E");
            Catalogo vogue = catalogoDAO.findByIsbn("R-006-F");
            Catalogo harvard = catalogoDAO.findByIsbn("R-007-G");
            Catalogo wired = catalogoDAO.findByIsbn("R-008-H");
            Catalogo economist = catalogoDAO.findByIsbn("R-009-I");
            Catalogo psico = catalogoDAO.findByIsbn("R-010-J");

            //Prestiti chiusi
            Prestito pr1 = new Prestito(aldo, rosa, LocalDate.of(2026, 1, 10), LocalDate.of(2026, 1, 25));
            Prestito pr2 = new Prestito(giov, anelli, LocalDate.of(2026, 2, 1), LocalDate.of(2026, 2, 20));
            Prestito pr3 = new Prestito(giaco, millenove, LocalDate.of(2026, 2, 15), LocalDate.of(2026, 3, 10));
            Prestito pr4 = new Prestito(desica, natGeo, LocalDate.of(2026, 3, 1), LocalDate.of(2026, 3, 15));
            Prestito pr5 = new Prestito(boldi, timeMag, LocalDate.of(2026, 3, 20), LocalDate.of(2026, 4, 5));

            //Prestiti chiusi in ritardo
            Prestito pr6 = new Prestito(checco, pascal, LocalDate.of(2026, 1, 5), LocalDate.of(2026, 2, 15));
            Prestito pr7 = new Prestito(verdone, zeno, LocalDate.of(2026, 2, 10), LocalDate.of(2026, 4, 1));
            Prestito pr8 = new Prestito(banfi, scienze, LocalDate.of(2026, 3, 1), LocalDate.of(2026, 4, 20));
            Prestito pr9 = new Prestito(lundini, focus, LocalDate.of(2026, 3, 15), LocalDate.of(2026, 5, 1));
            Prestito pr10 = new Prestito(maccio, inter, LocalDate.of(2026, 4, 1), LocalDate.of(2026, 5, 20));

            //Prestiti attivi
            Prestito pr11 = new Prestito(aldo, ghiaccio, LocalDate.of(2026, 6, 10));
            Prestito pr12 = new Prestito(giov, cecita, LocalDate.of(2026, 6, 12));
            Prestito pr13 = new Prestito(giaco, harry, LocalDate.of(2026, 6, 15));
            Prestito pr14 = new Prestito(desica, vogue, LocalDate.of(2026, 6, 18));
            Prestito pr15 = new Prestito(boldi, wired, LocalDate.of(2026, 6, 19));

            //Prestiti attivi ma oltre la data di scadenza
            Prestito pr16 = new Prestito(checco, fondazione, LocalDate.of(2026, 4, 1));
            Prestito pr17 = new Prestito(verdone, gatsby, LocalDate.of(2026, 4, 15));
            Prestito pr18 = new Prestito(banfi, harvard, LocalDate.of(2026, 5, 2));
            Prestito pr19 = new Prestito(lundini, economist, LocalDate.of(2026, 5, 5));
            Prestito pr20 = new Prestito(maccio, psico, LocalDate.of(2026, 5, 10));

//            prestitoDAO.save(pr1);
//            prestitoDAO.save(pr2);
//            prestitoDAO.save(pr3);
//            prestitoDAO.save(pr4);
//            prestitoDAO.save(pr5);
//            prestitoDAO.save(pr6);
//            prestitoDAO.save(pr7);
//            prestitoDAO.save(pr8);
//            prestitoDAO.save(pr9);
//            prestitoDAO.save(pr10);
//            prestitoDAO.save(pr11);
//            prestitoDAO.save(pr12);
//            prestitoDAO.save(pr13);
//            prestitoDAO.save(pr14);
//            prestitoDAO.save(pr15);
//            prestitoDAO.save(pr16);
//            prestitoDAO.save(pr17);
//            prestitoDAO.save(pr18);
//            prestitoDAO.save(pr19);
//            prestitoDAO.save(pr20);
        } catch (NotFoundException | SaveException ex) {
            System.out.println(ex.getMessage());
        }

        //endregion

        System.out.println(" ");

        //region RICERCA TRAMITE ISBN
//        try {
//            Catalogo elementoTrovato = catalogoDAO.findByIsbn("32978-92378");
//            System.out.println("L'elemento ricercato è: '" + elementoTrovato.getTitolo() + "'");
//        } catch (FindException ex) {
//            System.out.println(ex.getMessage());
//        }
        //endregion

        System.out.println(" ");

        //region RIMOZIONE TRAMITE ISBN
//        try {
//            catalogoDAO.deleteByIsbn("978-8806223412");
//        } catch (DeleteException ex) {
//            System.out.println(ex.getMessage());
//        }
        //endregion

        System.out.println(" ");

        //region RICERCA TRAMITE ANNO DI PUBBLICAZIONE
//        try {
//            Catalogo elementoTrovato = catalogoDAO.findByAnnoPubblicazione(1925);
//            System.out.println("L'elemento ricercato è: '" + elementoTrovato.getTitolo() + "'");
//        } catch (FindException ex) {
//            System.out.println(ex.getMessage());
//        }
        //endregion

        System.out.println(" ");

        //region RICERCA TRAMITE AUTORE
//        try {
//            Catalogo libroTrovato = catalogoDAO.findByAutore("LuIGI PirandeLLO");
//            System.out.println("L'elemento ricercato è: '" + libroTrovato.getTitolo() + "'");
//        } catch (FindException ex) {
//            System.out.println(ex.getMessage());
//        }
        //endregion

        System.out.println(" ");

        //region RICERCA TRAMITE TITOLO
//        try {
//            List<Catalogo> elementiTrovati = catalogoDAO.findByTitolo("il");
//            if (elementiTrovati.isEmpty()) {
//                System.out.println("Nessun elemento trovato con questo titolo.");
//            } else {
//                System.out.println("Elementi trovati:");
//                for (Catalogo c : elementiTrovati) {
//                    System.out.println("- " + c.getTitolo());
//                }
//            }
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
        //endregion

        System.out.println(" ");

        //region RICERCA ELEMENTI IN PRESTITO TRAMITE TESSERA
//        try {
//            List<Catalogo> inPrestito = prestitoDAO.findElementiInPrestito("TESSERA-ALDO");
//            System.out.println("Aldo Baglio ha attualmente in prestito " + inPrestito.size() + " elementi:");
//            for (Catalogo c : inPrestito) {
//                System.out.println("- " + c.getTitolo());
//            }
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//        }
        //endregion

        System.out.println(" ");

        //region RICERCA PRESTITI SCAUDUTI E NON RESTITUITI
//        try {
//            List<Prestito> prestitiScaduti = prestitoDAO.findPrestitiScaduti(LocalDate.now());
//            System.out.println("Ci sono " + prestitiScaduti.size() + " prestiti scaduti e non restituiti");
//            for (Prestito p : prestitiScaduti) {
//                System.out.println("- " + p.getCatalogo().getTitolo() + " (" + p.getUtente().getNome() + " " + p.getUtente().getCognome() + ")");
//                System.out.println("Doveva restituirlo il: " + p.getDataResitutzionePrevista());
//                System.out.println(" ");
//            }
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//        }
        //endregion
    }
}
