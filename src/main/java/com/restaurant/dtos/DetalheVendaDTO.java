package com.restaurant.dtos;

import com.restaurant.models.Enums.FormaDePagamento;
import com.restaurant.models.FuncionarioEntity;
import com.restaurant.models.ProdutosEntity;
import com.restaurant.models.RestauranteEntity;

import java.time.LocalDateTime;
import java.util.List;

public record DetalheVendaDTO(
        Long id,
        RestauranteEntity restaurante,
        FuncionarioEntity funcionario,
        List<ProdutosEntity> produtos,
        double somaTotal,
        FormaDePagamento formaDePagamento,
        LocalDateTime dataDaVenda
) {
}
