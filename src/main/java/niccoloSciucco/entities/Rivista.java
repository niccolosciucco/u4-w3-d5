package niccoloSciucco.entities;

import jakarta.persistence.*;
import niccoloSciucco.enums.Periodicita;

@Entity
@Table(name = "riviste")
@DiscriminatorValue("Rivista")
public class Rivista extends Catalogo {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    protected Rivista() {
    }

    public Rivista(String codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}
