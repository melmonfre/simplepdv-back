package com.restaurant.dtos;

public record CreateInsumerDTO(
        double preco,
        String nome,
        String medida,
        String categoria,
        Integer quantidade
) {
}
