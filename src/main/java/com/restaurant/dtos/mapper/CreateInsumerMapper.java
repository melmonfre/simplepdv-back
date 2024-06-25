package com.restaurant.dtos.mapper;

import com.restaurant.dtos.CreateInsumerDTO;
import com.restaurant.models.InsumersEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateInsumerMapper {
    CreateInsumerDTO insumerEntityToInsumerDTO (InsumersEntity insumersEntity);

    InsumersEntity insumerDtoToInsumerEntity (CreateInsumerDTO createInsumerDTO);
}
