package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.dtos.PanierDto;
import com.ecommerce.ecommerce.dtos.PanierProduitDto;
import com.ecommerce.ecommerce.entities.Panier;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PanierMapper {

    public PanierDto toDto(Panier entity) {
        PanierDto dto = new PanierDto();
        dto.setId(entity.getId());
        dto.setClient(entity.getClient());
        dto.setProduits(entity.getProduits()
                .stream()
                .map(pp -> {
                    PanierProduitDto pDto = new PanierProduitDto();
                    pDto.setProduitId(pp.getProduit().getId());
                    pDto.setQuantite(pp.getQuantite());
                    return pDto;
                })
                .collect(Collectors.toList()));

        double total = entity.getProduits().stream()
                .mapToDouble(pp -> pp.getProduit().getPrix() * pp.getQuantite())
                .sum();
        dto.setTotal(total);

        return dto;
    }
}
