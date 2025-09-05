package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.dtos.CategorieDto;
import com.ecommerce.ecommerce.entities.Categorie;
import org.springframework.stereotype.Component;


import java.util.stream.Collectors;

@Component
public class CategorieMapper {

        public CategorieDto toDto(Categorie entity) {
            if (entity == null) return null;

            CategorieDto dto = new CategorieDto();
            dto.setId(entity.getId());
            dto.setNom(entity.getNom());
            dto.setDescription(entity.getDescription());
            dto.setParentId(entity.getParent() != null ? entity.getParent().getId() : null);
            dto.setSousCategoreisIds(
                    entity.getSousCategories()
                            .stream()
                            .map(Categorie::getId)
                            .collect(Collectors.toList())
            );
            dto.setProduitsIds(
                    entity.getProduits()
                            .stream()
                            .map(p -> p.getId())
                            .collect(Collectors.toList())
            );
            return dto;
        }


        public Categorie toEntity(CategorieDto dto) {
            if (dto == null) return null;

            Categorie entity = new Categorie();
            entity.setId(dto.getId());
            entity.setNom(dto.getNom());
            entity.setDescription(dto.getDescription());
            return entity;
        }
}
