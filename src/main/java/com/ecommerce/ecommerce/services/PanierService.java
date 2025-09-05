package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.dtos.PanierDto;
import com.ecommerce.ecommerce.dtos.PanierProduitDto;
import com.ecommerce.ecommerce.entities.Panier;
import com.ecommerce.ecommerce.entities.PanierProduit;
import com.ecommerce.ecommerce.mapper.PanierMapper;
import com.ecommerce.ecommerce.repositories.PanierRepository;
import com.ecommerce.ecommerce.repositories.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PanierService {

    private final PanierRepository panierRepository;
    private final ProduitRepository produitRepository;
    private final PanierMapper panierMapper;

    public PanierService(PanierRepository panierRepository,
                         ProduitRepository produitRepository,
                         PanierMapper panierMapper) {
        this.panierRepository = panierRepository;
        this.produitRepository = produitRepository;
        this.panierMapper = panierMapper;
    }

    public PanierDto create(String client) {
        Panier panier = new Panier();
        panier.setClient(client);
        return panierMapper.toDto(panierRepository.save(panier));
    }

    public Optional<PanierDto> getById(Long id) {
        return panierRepository.findById(id).map(panierMapper::toDto);
    }

    public PanierDto addProduct(Long panierId, PanierProduitDto produitDto) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow();

        PanierProduit pp = new PanierProduit();
        pp.setPanier(panier);
        pp.setQuantite(produitDto.getQuantite());
        pp.setProduit(produitRepository.findById(produitDto.getProduitId())
                .orElseThrow(() -> new RuntimeException("Produit non trouvé")));

        panier.getProduits().add(pp);
        return panierMapper.toDto(panierRepository.save(panier));
    }

    public PanierDto removeProduct(Long panierId, Long produitId) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier non trouvé"));

        panier.getProduits().removeIf(pp -> pp.getProduit().getId().equals(produitId));
        return panierMapper.toDto(panierRepository.save(panier));
    }

    public PanierDto updateProductQuantity(Long panierId, PanierProduitDto produitDto) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier non trouvé"));

        panier.getProduits().forEach(pp -> {
            if (pp.getProduit().getId().equals(produitDto.getProduitId())) {
                pp.setQuantite(produitDto.getQuantite());
            }
        });

        return panierMapper.toDto(panierRepository.save(panier));
    }
}
