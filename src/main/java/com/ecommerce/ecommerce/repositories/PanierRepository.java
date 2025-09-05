package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<Panier, Long> {
}
