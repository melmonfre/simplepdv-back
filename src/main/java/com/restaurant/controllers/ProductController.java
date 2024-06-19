package com.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dtos.CreateProductDTO;
import com.restaurant.services.useCases.ProductUseCase;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductUseCase productUseCase;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated CreateProductDTO createProductDTO){
        try{
          

          var result =   this.productUseCase.create(createProductDTO);

          return ResponseEntity.ok().body(result);

        }catch(Exception exception){
            return ResponseEntity.badRequest().body(exception);
        }
    }
}
