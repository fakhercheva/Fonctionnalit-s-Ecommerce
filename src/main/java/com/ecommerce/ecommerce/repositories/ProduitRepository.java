package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
