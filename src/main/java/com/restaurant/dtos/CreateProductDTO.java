package com.restaurant.dtos;

import com.restaurant.models.InsumersEntity;

import java.util.List;


public record CreateProductDTO(
        String nome,
        double precoCusto,
        double precoVenda,
        List<InsumersEntity> ingredientes,
        String medida,
        String categoria
) {
}
