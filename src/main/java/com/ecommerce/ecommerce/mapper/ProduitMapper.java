package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.dtos.ProduitDto;
import com.ecommerce.ecommerce.entities.Produit;
import org.springframework.stereotype.Component;

@Component
public class ProduitMapper {


    public ProduitDto toDto(Produit entity) {
        if (entity == null) return null;

        ProduitDto dto = new ProduitDto();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrix(entity.getPrix());
        dto.setQuantiteStock(entity.getQuantiteStock());
        dto.setCategorieId(entity.getCategorie() != null ? entity.getCategorie().getId() : null);
        return dto;
    }

    public Produit toEntity(ProduitDto dto) {
        if (dto == null) return null;

        Produit entity = new Produit();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setPrix(dto.getPrix());
        entity.setQuantiteStock(dto.getQuantiteStock());
        return entity;
    }
}
