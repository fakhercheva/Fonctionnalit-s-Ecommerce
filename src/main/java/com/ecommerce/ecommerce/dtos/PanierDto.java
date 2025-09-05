package com.ecommerce.ecommerce.dtos;

import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PanierDto {
    private Long id;
    private String client;
    private List<PanierProduitDto> produits;
    private double total;


}
