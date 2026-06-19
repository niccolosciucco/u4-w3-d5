package niccoloSciucco.entities;

import jakarta.persistence.*;
import niccoloSciucco.enums.Genere;

@Entity
@Table(name = "libri")
@DiscriminatorValue("Libro")
public class Libro extends Catalogo {
    @Column(nullable = false)
    private String autore;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genere genere;

    protected Libro() {
    }

    public Libro(String codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine, String autore, Genere genere) {
        super(codiceISBN, titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
}
