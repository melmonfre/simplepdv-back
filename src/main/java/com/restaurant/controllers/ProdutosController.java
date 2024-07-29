package com.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dtos.CriarProdutoDTO;
import com.restaurant.services.ServicosProdutos;

@RestController
@RequestMapping("/produto")
public class ProdutosController {

    @Autowired
    private ServicosProdutos ServicosProdutos;

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody @Validated CriarProdutoDTO criarProdutoDTO){
        try{
          

          var resultado =   this.ServicosProdutos.criar(criarProdutoDTO);

          return ResponseEntity.ok().body(resultado);

        }catch(Exception exception){
            return ResponseEntity.badRequest().body(exception);
        }
    }
}
