package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
