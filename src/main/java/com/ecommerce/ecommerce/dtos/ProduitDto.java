package com.ecommerce.ecommerce.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProduitDto {
    private Long id;

    private String nom;

    private double prix;

    private int quantiteStock;

    // ref to category
    private Long categorieId;
}
