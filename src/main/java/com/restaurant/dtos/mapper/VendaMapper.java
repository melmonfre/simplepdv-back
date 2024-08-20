package com.restaurant.dtos.mapper;

import com.restaurant.dtos.CriarVendaDTO;
import com.restaurant.dtos.DetalheVendaDTO;
import com.restaurant.models.VendaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendaMapper {

    CriarVendaDTO vendaEntityParaCriarVendaDto(VendaEntity vendaEntity);
    VendaEntity criarVendaDtoParaVendaEntity(CriarVendaDTO criarVendaDTO);
    DetalheVendaDTO vendaEntityParaDetalheVendaDto(VendaEntity vendaEntity);
    VendaEntity detalheVendaDtoParaVendaEntity(DetalheVendaDTO detalheVendaDTO);
}
