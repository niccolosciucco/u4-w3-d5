package niccoloSciucco.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(name = "data_di_nascita", nullable = false)
    private LocalDate dataDiNascita;
    @Column(name = "numero_tessera", nullable = false)
    private String numeroTessera;

    protected Utente() {
    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita, String numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroTessera='" + numeroTessera + '\'' +
                '}';
    }
}
