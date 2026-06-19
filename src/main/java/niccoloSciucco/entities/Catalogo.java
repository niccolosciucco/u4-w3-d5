package niccoloSciucco.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public abstract class Catalogo {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "codice_ISBN", nullable = false, unique = true)
    private String codiceISBN;
    @Column(nullable = false)
    private String titolo;
    @Column(name = "anno_di_pubblicazione", nullable = false)
    private int annoDiPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;

    protected Catalogo() {
    }

    public Catalogo(String codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getTitolo() {
        return titolo;
    }
}
