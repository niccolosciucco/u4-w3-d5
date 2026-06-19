package niccoloSciucco.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "id_elemento_prestato", nullable = false)
    private Catalogo catalogo;
    @Column(name = "data_inizio_prestito", nullable = false)
    private LocalDate dataInizioPrestito;
    @Column(name = "data_restituzione_prevista", nullable = false)
    private LocalDate dataResitutzionePrevista;
    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    protected Prestito() {
    }

    // Costruttore per chi non ha restituito il libro (data restituzione = null)
    public Prestito(Utente utente, Catalogo catalogo, LocalDate dataInizioPrestito) {
        this.utente = utente;
        this.catalogo = catalogo;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataResitutzionePrevista = dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = null;
    }

    // Costruttore per chi ha restituito il libro
    public Prestito(Utente utente, Catalogo catalogo, LocalDate dataInizioPrestito, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.catalogo = catalogo;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataResitutzionePrevista = dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public LocalDate getDataResitutzionePrevista() {
        return dataResitutzionePrevista;
    }
}
