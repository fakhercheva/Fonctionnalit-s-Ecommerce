package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.dtos.CategorieDto;
import com.ecommerce.ecommerce.entities.Categorie;
import com.ecommerce.ecommerce.mapper.CategorieMapper;
import com.ecommerce.ecommerce.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    private final CategorieRepository categorieRepository;
    private final CategorieMapper categorieMapper;

    public CategoriesService(CategorieRepository categorieRepository, CategorieMapper categorieMapper) {
        this.categorieRepository = categorieRepository;
        this.categorieMapper = categorieMapper;
    }

    public List<CategorieDto> findAll() {
        return categorieRepository.findAll()
                .stream()
                .map(categorieMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<CategorieDto> findById(Long id) {
        return categorieRepository.findById(id).map(categorieMapper::toDto);
    }

    public CategorieDto save(CategorieDto dto) {
        Categorie entity = categorieMapper.toEntity(dto);

        if (dto.getParentId() != null) {
            categorieRepository.findById(dto.getParentId())
                    .ifPresent(entity::setParent);
        }

        return categorieMapper.toDto(categorieRepository.save(entity));
    }

    public void delete(Long id) {
        categorieRepository.deleteById(id);
    }
}
