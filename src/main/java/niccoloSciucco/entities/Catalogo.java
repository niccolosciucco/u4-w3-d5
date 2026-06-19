package niccoloSciucco.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)
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
    private int numero_pagine;
}
