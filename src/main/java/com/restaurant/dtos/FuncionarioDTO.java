package com.restaurant.dtos;


public record FuncionarioDTO(
        String nome,
        String email,
        String senha,
        Long restauranteId
){ }