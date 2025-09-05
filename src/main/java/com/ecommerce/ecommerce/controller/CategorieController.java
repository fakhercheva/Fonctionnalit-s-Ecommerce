package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dtos.CategorieDto;
import com.ecommerce.ecommerce.services.CategoriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    private final CategoriesService categorieService;

    public CategorieController(CategoriesService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/getAll")
    public List<CategorieDto> getAllCategoreies() {
        return categorieService.findAll();
    }

    @GetMapping("/find/{id}")
    public CategorieDto getCatgorieById(@PathVariable Long id) {
        return categorieService.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
    }

    @PostMapping("/addCategorie")
    public CategorieDto createCategorie(@RequestBody CategorieDto dto) {
        return categorieService.save(dto);
    }

    @PutMapping("/update/{id}")
    public CategorieDto updateCategorie(@PathVariable Long id, @RequestBody CategorieDto dto) {
        dto.setId(id);
        return categorieService.save(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieService.delete(id);
    }
}
