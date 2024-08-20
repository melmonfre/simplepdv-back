package com.restaurant.dtos;

import com.restaurant.models.InsumosEntity;
import com.restaurant.models.ProdutosEntity;
import com.restaurant.models.RestauranteEntity;

import java.time.LocalDateTime;

public record DetalheEstoqueDTO(
        Long id,
        RestauranteEntity restaurante,
        ProdutosEntity produto,
        InsumosEntity insumo,
        double quantidadeMinima,
        double quantidadeAtual,
        LocalDateTime atualizacao
) {
}
