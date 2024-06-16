package com.restaurant.repositories;

import com.restaurant.models.InsumersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumersRepository extends JpaRepository<InsumersEntity, Long> {
}
