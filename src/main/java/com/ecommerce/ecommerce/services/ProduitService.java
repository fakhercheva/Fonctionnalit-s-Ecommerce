package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.dtos.ProduitDto;
import com.ecommerce.ecommerce.entities.Produit;
import com.ecommerce.ecommerce.mapper.ProduitMapper;
import com.ecommerce.ecommerce.repositories.CategorieRepository;
import com.ecommerce.ecommerce.repositories.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;
    private final ProduitMapper produitMapper;

    public ProduitService(ProduitRepository produitRepository,
                          CategorieRepository categorieRepository,
                          ProduitMapper produitMapper) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
        this.produitMapper = produitMapper;
    }

    public List<ProduitDto> findAll() {
        return produitRepository.findAll()
                .stream()
                .map(produitMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ProduitDto> findById(Long id) {
        return produitRepository.findById(id).map(produitMapper::toDto);
    }

    public ProduitDto save(ProduitDto dto) {
        Produit entity = produitMapper.toEntity(dto);

        if (dto.getCategorieId() != null) {
            categorieRepository.findById(dto.getCategorieId())
                    .ifPresent(entity::setCategorie);
        }

        return produitMapper.toDto(produitRepository.save(entity));
    }

    public void delete(Long id) {
        produitRepository.deleteById(id);
    }
}
