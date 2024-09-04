package com.restaurant.dtos.mapper;

import com.restaurant.dtos.CriarEstoqueDTO;
import com.restaurant.dtos.DetalheEstoqueDTO;
import com.restaurant.models.EstoqueEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstoqueMapper {
    CriarEstoqueDTO estoqueEntityParaCriarEstoqueDto(EstoqueEntity estoqueEntity);
    EstoqueEntity criarEstoqueDtoParaEstoqueEntity(DetalheEstoqueDTO criarEstoqueDTO);

    DetalheEstoqueDTO estoqueEntityParaDetalheEstoqueDto(EstoqueEntity estoqueEntity);

    EstoqueEntity detalheEstoqueDtoParaEstoqueEntity(DetalheEstoqueDTO detalheEstoqueDTO);
}
