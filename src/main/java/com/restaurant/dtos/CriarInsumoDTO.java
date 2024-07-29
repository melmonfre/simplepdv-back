package com.restaurant.dtos;

public record CriarInsumoDTO(
        double preco,
        String nome,
        String medida,
        String categoria,
        Integer quantidade
) {
}
