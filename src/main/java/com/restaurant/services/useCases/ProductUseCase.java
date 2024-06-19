package com.restaurant.services.useCases;

import com.restaurant.dtos.CreateProductDTO;
import com.restaurant.dtos.mapper.CreateProductMapper;
import com.restaurant.models.InsumersEntity;
import com.restaurant.models.ProductsEntity;
import com.restaurant.repositories.InsumersRepository;
import com.restaurant.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductUseCase {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CreateProductMapper createProductMapper;
    @Autowired
    private InsumersRepository insumersRepository;

    public CreateProductDTO create(CreateProductDTO createProductDTO) {
        try {
            List<InsumersEntity> insumersEntityList = new ArrayList<>();

            createProductDTO.ingredientes().forEach(insumer -> {
                if (insumer.getId() != null) {
                    insumer = insumersRepository.findById(insumer.getId()).orElseThrow(() -> new RuntimeException("Insumo não encontrado"));
                }
                insumersEntityList.add(insumer);
            });

            ProductsEntity productsEntity = this.createProductMapper.productDtoToProductEntity(createProductDTO);
            productsEntity.setIngredientes(insumersEntityList);

            return this.createProductMapper.productEntityToProductDTO(productsRepository.save(productsEntity));

        } catch (RuntimeException exception) {
            throw new RuntimeException(exception);
        }
    }
}
