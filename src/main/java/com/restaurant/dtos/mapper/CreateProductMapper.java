package com.restaurant.dtos.mapper;

import org.mapstruct.Mapper;

import com.restaurant.dtos.CreateProductDTO;
import com.restaurant.models.ProductsEntity;

@Mapper(componentModel = "spring")
public interface CreateProductMapper {
    CreateProductDTO productEntityToProductDTO (ProductsEntity productsEntity);

    ProductsEntity productDtoToProductEntity (CreateProductDTO productDTO);
}
