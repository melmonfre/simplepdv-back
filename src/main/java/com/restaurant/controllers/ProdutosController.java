package com.restaurant.controllers;

import com.restaurant.dtos.DetalheProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.restaurant.dtos.CriarProdutoDTO;
import com.restaurant.services.ServicosProdutos;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutosController {

    @Autowired
    private ServicosProdutos servicosProdutos;

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody @Validated CriarProdutoDTO criarProdutoDTO){
        try{
            var resultado =   this.servicosProdutos.criar(criarProdutoDTO);
            return ResponseEntity.ok().body(resultado);
        }catch(Exception exception){
            return ResponseEntity.badRequest().body(exception);
        }
    }
    @GetMapping
    public ResponseEntity listarProdutos(){
        List<DetalheProduto> listarProdutos = servicosProdutos.retornaListaDeProdutos();
        return ResponseEntity.ok(listarProdutos);
    }
    @GetMapping("/{id}")
    public ResponseEntity pegarProdutoPorId(@PathVariable Long id){
        DetalheProduto pegarProdutoPorId = servicosProdutos.buscarProdutoPorId(id);
        return ResponseEntity.ok(pegarProdutoPorId);
    }
    @PutMapping("/{id}")
    public ResponseEntity editarProduto (@PathVariable Long id, DetalheProduto dto){
        DetalheProduto editarProduto = servicosProdutos.alteraProduto(id, dto);
        return ResponseEntity.ok(editarProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirProduto(@PathVariable Long id){
        servicosProdutos.deletaProduto(id);
        return ResponseEntity.noContent().build();
    }
}
