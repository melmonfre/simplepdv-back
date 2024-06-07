package com.restaurant.repositories;

import com.restaurant.models.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
}
