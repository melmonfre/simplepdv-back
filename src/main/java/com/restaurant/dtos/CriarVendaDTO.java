package com.restaurant.dtos;

import com.restaurant.models.Enums.FormaDePagamento;
import com.restaurant.models.FuncionarioEntity;
import com.restaurant.models.ProdutosEntity;
import com.restaurant.models.RestauranteEntity;

import java.util.List;

public record CriarVendaDTO(
        RestauranteEntity restaurante,
        FuncionarioEntity funcionario,
        List<ProdutosEntity> produtosEntities,
        FormaDePagamento formaDePagamento
){
}
