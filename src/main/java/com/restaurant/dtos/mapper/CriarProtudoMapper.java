package com.restaurant.dtos.mapper;

import org.mapstruct.Mapper;

import com.restaurant.dtos.CriarProdutoDTO;
import com.restaurant.models.ProdutosEntity;

@Mapper(componentModel = "spring")
public interface CriarProtudoMapper {
    CriarProdutoDTO produtoEntityParaProdutoDTO (ProdutosEntity produtosEntity);

    ProdutosEntity produtoDtoParaProdutoEntity(CriarProdutoDTO productDTO);
}
