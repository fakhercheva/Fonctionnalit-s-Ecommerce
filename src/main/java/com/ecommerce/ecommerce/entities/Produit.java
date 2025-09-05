package com.ecommerce.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString @Getter @Setter
public class Produit {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double prix;
    private int quantiteStock;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
