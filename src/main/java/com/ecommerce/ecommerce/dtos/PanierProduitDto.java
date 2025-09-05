package com.ecommerce.ecommerce.dtos;

import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PanierProduitDto {
    private Long produitId;
    private int quantite;

}
