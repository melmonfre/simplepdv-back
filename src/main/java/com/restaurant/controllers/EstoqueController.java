package com.restaurant.controllers;

import com.restaurant.dtos.CriarEstoqueDTO;
import com.restaurant.dtos.DetalheEstoqueDTO;
import com.restaurant.services.ServicosEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private ServicosEstoque servicosEstoque;
    @PostMapping("/criar")
    public ResponseEntity criarEstoque(@RequestBody @Validated DetalheEstoqueDTO detalheEstoqueDTO){
        DetalheEstoqueDTO criarEstoque = servicosEstoque.criarEstoque(detalheEstoqueDTO);
        return ResponseEntity.ok(criarEstoque);
    }
    @GetMapping
    public ResponseEntity listarEstoque(){
        List<DetalheEstoqueDTO> listarEstoque = servicosEstoque.listarEstoque();
        return ResponseEntity.ok(listarEstoque);
    }
    @GetMapping("/{id}")
    public ResponseEntity pegarEstoquePorId(@PathVariable Long id){
        DetalheEstoqueDTO pegarEstoquePorId = servicosEstoque.pegarEstoquePorId(id);
        return ResponseEntity.ok(pegarEstoquePorId);
    }
    @PutMapping("/{id}")
    public ResponseEntity editarEstoque(@PathVariable Long id, @RequestBody CriarEstoqueDTO detalheEstoqueDTO){
        DetalheEstoqueDTO editarEstoque = servicosEstoque.editarEstoque(id,detalheEstoqueDTO);
        return ResponseEntity.ok(editarEstoque);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity excluirEstoque(@PathVariable Long id) {
        servicosEstoque.excluirEstoque(id);
        return ResponseEntity.noContent().build();

    }
}