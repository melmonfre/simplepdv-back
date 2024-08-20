package com.restaurant.dtos.mapper;

import com.restaurant.dtos.FuncionarioDTO;
import com.restaurant.models.FuncionarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    @Mapping(source = "restaurante.id", target = "restauranteId")
    FuncionarioDTO funcionarioEntityToFuncionarioDto(FuncionarioEntity funcionarioEntity);

    @Mapping(source = "restauranteId", target = "restaurante.id")
    FuncionarioEntity funcionarioDtoToFuncionarioEntity(FuncionarioDTO funcionarioDTO);
}
