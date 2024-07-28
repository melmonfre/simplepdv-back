package com.restaurant.dtos.mapper;

import com.restaurant.dtos.CriarInsumoDTO;
import com.restaurant.models.InsumosEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriarInsumoMapper {
    CriarInsumoDTO insumoEntityParaInsumoDTO(InsumosEntity insumosEntity);

    InsumosEntity insumoDtoParaInsumoEntity(CriarInsumoDTO criarInsumoDTO);
}
