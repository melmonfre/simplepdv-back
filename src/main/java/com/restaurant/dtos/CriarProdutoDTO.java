package com.restaurant.dtos;

import com.restaurant.models.InsumosEntity;

import java.util.List;


public record CriarProdutoDTO(
        String nome,
        double precoCusto,
        double precoVenda,
        List<InsumosEntity> ingredientes,
        String medida,
        String categoria
) {
}
