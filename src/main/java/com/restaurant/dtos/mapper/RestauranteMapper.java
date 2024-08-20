package com.restaurant.dtos.mapper;


import com.restaurant.dtos.RestauranteDTO;
import com.restaurant.models.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {

    @Mapping(target = "funcionarios", ignore = true)
    @Mapping(target = "cardapio", ignore = true)
    @Mapping(target = "insumos", ignore = true)
    @Mapping(target = "vendas", ignore = true)
    @Mapping(target = "itensEmEstoque", ignore = true)
    RestauranteEntity restauranteDTOtoRestauranteEntity(RestauranteDTO dto);

    @Mapping(target = "funcionariosIds", ignore = true)
    @Mapping(target = "cardapioIds", ignore = true)
    @Mapping(target = "insumosIds", ignore = true)
    @Mapping(target = "vendasIds", ignore = true)
    @Mapping(target = "itensEmEstoqueIds", ignore = true)
    RestauranteDTO restauranteEntitytoRestauranteDTO(RestauranteEntity restaurante);

}
