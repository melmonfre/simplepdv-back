package com.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dtos.CreateInsumerDTO;
import com.restaurant.services.useCases.InsumerUseCase;

@RestController
@RequestMapping("/insumer")
public class InsumerController {
   
    @Autowired
    private InsumerUseCase insumerUseCase;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated CreateInsumerDTO createInsumerDTO){
       
        try {
            CreateInsumerDTO result = this.insumerUseCase.create(createInsumerDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}