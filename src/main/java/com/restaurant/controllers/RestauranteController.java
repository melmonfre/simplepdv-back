package com.restaurant.controllers;

import com.restaurant.dtos.RestauranteDTO;
import com.restaurant.services.ServicoRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private ServicoRestaurante servicoRestaurante;

    @GetMapping("/getAll")
    public ResponseEntity<List<?>> listarTodos() {
        List<RestauranteDTO> restaurantes = servicoRestaurante.listarTodos();
        return ResponseEntity.ok().body(restaurantes);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            RestauranteDTO restauranteDTO = servicoRestaurante.buscarPorId(id);
        return ResponseEntity.ok().body(restauranteDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel encontrar o restaurante solicitado: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> criar(@RequestBody RestauranteDTO restauranteDTO) {
        try {
            RestauranteDTO novoRestaurante = servicoRestaurante.criar(restauranteDTO);
            return ResponseEntity.status(201).body(novoRestaurante);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel criar restaurante: "+ e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody RestauranteDTO restauranteDTO) {
        try {
            RestauranteDTO restauranteAtualizado = servicoRestaurante.atualizar(id, restauranteDTO);
            return ResponseEntity.ok().body(restauranteAtualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel atualizar o restaurante: "+ e.getMessage());

        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            servicoRestaurante.deletar(id);
            return ResponseEntity.ok().body("Restaurante deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel deletar o restaurante: "+ e.getMessage());            
        }
    }
}
