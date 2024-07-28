package com.restaurant.repositories;

import com.restaurant.models.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository
        extends JpaRepository<ProdutosEntity, Long> {
}
