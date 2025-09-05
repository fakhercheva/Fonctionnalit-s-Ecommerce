package com.ecommerce.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString @Getter @Setter
public class Categorie {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Categorie parent;

    // Ce champ représente les sous-catégories associées à une catégorie.
    // On utilise un Set pour garantir l'unicité des sous-catégories (pas de doublons).
    // HashSet est choisi pour ses performances en insertion et recherche, et parce qu'il n'impose pas d'ordre particulier.
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Categorie> sousCategories =  new HashSet<>();

    // Ce champ représente les produits associés à une catégorie.
    // On utilise un Set pour garantir l'unicité des produits (pas de doublons).
    // La relation @OneToMany permet de lier chaque catégorie à plusieurs produits, avec cascade sur toutes les opérations.
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private Set<Produit> produits = new HashSet<>();


}
