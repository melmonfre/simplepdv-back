package com.restaurant.dtos.mapper;

import com.restaurant.dtos.CreateProductDTO;
import com.restaurant.models.ProductsEntity;

public interface CreateProductMapper {
    CreateProductDTO productEntityToProductDTO (ProductsEntity productsEntity);

    ProductsEntity productDtoToModel (CreateProductDTO productDTO);
}
