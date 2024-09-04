package com.restaurant.controllers;

import com.restaurant.dtos.CriarVendaDTO;
import com.restaurant.dtos.DetalheVendaDTO;
import com.restaurant.services.ServicosVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private ServicosVenda servicosVenda;

    @PostMapping("/create")
    public ResponseEntity<?> criarVenda(@RequestBody CriarVendaDTO vendaDTO) {
        try {
            DetalheVendaDTO novaVenda = servicosVenda.criarVenda(vendaDTO);
            return ResponseEntity.status(201).body(novaVenda);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível criar a venda: " + e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<?>> listarVendas() {
        List<DetalheVendaDTO> vendas = servicosVenda.listarVendas();
        return ResponseEntity.ok().body(vendas);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> pegarVendaPorId(@PathVariable Long id) {
        try {
            DetalheVendaDTO venda = servicosVenda.pegarVendaPorId(id);
            return ResponseEntity.ok().body(venda);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível encontrar a venda: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> editarVenda(@PathVariable Long id, @RequestBody CriarVendaDTO vendaDTO) {
        try {
            DetalheVendaDTO vendaAtualizada = servicosVenda.editarVenda(id, vendaDTO);
            return ResponseEntity.ok().body(vendaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível atualizar a venda: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> excluirVenda(@PathVariable Long id) {
        try {
            servicosVenda.excluirVenda(id);
            return ResponseEntity.ok().body("Venda excluída com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível excluir a venda: " + e.getMessage());
        }
    }
}
