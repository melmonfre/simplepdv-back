package com.restaurant.dtos;

import com.restaurant.models.InsumosEntity;
import com.restaurant.models.ProdutosEntity;
import com.restaurant.models.RestauranteEntity;

public record CriarEstoqueDTO(
        RestauranteEntity restaurante,
        ProdutosEntity produtosEntity,
        InsumosEntity insumosEntity,
        Double quantidadeMinima,
        Double quantidadeAtual
) {
}
