package com.restaurant.repositories;

import com.restaurant.models.InsumosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumosRepository extends JpaRepository<InsumosEntity, Long> {
}
