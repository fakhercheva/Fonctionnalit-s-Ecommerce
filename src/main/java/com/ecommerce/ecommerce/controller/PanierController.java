package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dtos.PanierDto;
import com.ecommerce.ecommerce.dtos.PanierProduitDto;
import com.ecommerce.ecommerce.services.PanierService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paniers")
public class PanierController {

    private final PanierService panierService;

    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @PostMapping
    public PanierDto createPanier(@RequestParam String client) {
        return panierService.create(client);
    }

    @GetMapping("/{id}")
    public PanierDto getPanier(@PathVariable Long id) {
        return panierService.getById(id)
                .orElseThrow(() -> new RuntimeException("Panier non trouvé"));
    }

    @PostMapping("/{id}/produits")
    public PanierDto addProduit(@PathVariable Long id, @RequestBody PanierProduitDto produit) {
        return panierService.addProduct(id, produit);
    }

    @DeleteMapping("/{id}/produits/{produitId}")
    public PanierDto removeProduit(@PathVariable Long id, @PathVariable Long produitId) {
        return panierService.removeProduct(id, produitId);
    }

    @PutMapping("/{id}/produits")
    public PanierDto updateProduit(@PathVariable Long id, @RequestBody PanierProduitDto produit) {
        return panierService.updateProductQuantity(id, produit);
    }
}
