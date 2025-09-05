package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dtos.CategorieDto;
import com.ecommerce.ecommerce.dtos.ProduitDto;
import com.ecommerce.ecommerce.services.CategoriesService;
import com.ecommerce.ecommerce.services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/getAll")
    public List<ProduitDto> getAll() {
        return produitService.findAll();
    }

    @GetMapping("/find/{id}")
    public ProduitDto getById(@PathVariable Long id) {
        return produitService.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    @PutMapping("/updateProduit/{id}")
    public ProduitDto update(@PathVariable Long id, @RequestBody ProduitDto dto) {
        dto.setId(id);
        return produitService.save(dto);
    }

    @DeleteMapping("/deleteProduit/{id}")
    public void delete(@PathVariable Long id) {
        produitService.delete(id);
    }
}
