package com.restaurant.services.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dtos.CreateProductDTO;
import com.restaurant.dtos.mapper.CreateProductMapper;
import com.restaurant.models.ProductsEntity;
import com.restaurant.repositories.InsumersRepository;
import com.restaurant.repositories.ProductsRepository;

@Service
public class ProductUseCase {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CreateProductMapper createProductMapper;
    @Autowired
    private InsumersRepository insumersRepository;

    public CreateProductDTO create(CreateProductDTO createProductDTO){
        try{

            
            ProductsEntity productsEntity = this.createProductMapper.productDtoToProductEntity(createProductDTO);

            var productSaved = this.productsRepository.save(productsEntity);

            CreateProductDTO productDTO = this.createProductMapper.productEntityToProductDTO(productSaved); 

            return productDTO;

        }catch(RuntimeException exception){
            throw new RuntimeException(exception);
        }
         
    }
    
}
