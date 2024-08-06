package com.restaurant.repositories;

import com.restaurant.models.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository< VendaEntity, Long> {
}
