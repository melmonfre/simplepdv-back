package com.restaurant.dtos;



import java.util.List;

public record RestauranteDTO(
        String nomeProprietario,
        String nomeRestaurante,
        String telefone,
        String email,
        String senha,
        String endereco,
        String CNPJ,
        List<Long> funcionariosIds,
        List<Long> cardapioIds,
        List<Long> insumosIds,
        List<Long> vendasIds,
        List<Long> itensEmEstoqueIds) {
}

