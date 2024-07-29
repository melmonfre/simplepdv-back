package com.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dtos.CriarInsumoDTO;
import com.restaurant.services.ServicosInsumos;

@RestController
@RequestMapping("/insumo")
public class InsumosController {
   
    @Autowired
    private ServicosInsumos servicosInsumos;

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody @Validated CriarInsumoDTO criarInsumoDTO){
       
        try {
            CriarInsumoDTO resultado = this.servicosInsumos.criar(criarInsumoDTO);
            return ResponseEntity.ok().body(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}