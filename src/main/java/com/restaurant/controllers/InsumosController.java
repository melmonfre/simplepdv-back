package com.restaurant.controllers;

import com.restaurant.dtos.DetalheInsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.restaurant.dtos.CriarInsumoDTO;
import com.restaurant.services.ServicosInsumos;

import java.util.List;

@RestController
@RequestMapping("/insumo")
public class InsumosController {

    @Autowired
    private ServicosInsumos servicosInsumos;

    @PostMapping("/criar")
    public ResponseEntity<?> criarInsumo(@RequestBody @Validated CriarInsumoDTO criarInsumoDTO) {

        try {
            CriarInsumoDTO resultado = this.servicosInsumos.criar(criarInsumoDTO);
            return ResponseEntity.ok().body(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<DetalheInsumo> listarInsumos() {
        return servicosInsumos.retornaListaDeInsumos();
    }

    @GetMapping("/{id}")
    public DetalheInsumo pegarInsumoPorId(@PathVariable Long id) {
        return servicosInsumos.buscaInsumoPorId(id);
    }

    @PutMapping("/{id}")
    public DetalheInsumo editarInsumo(@PathVariable Long id, @RequestBody DetalheInsumo insumo) {
        return servicosInsumos.alterarInsumo(id, insumo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirInsumo(@PathVariable Long id) {
        servicosInsumos.deletaInsumo(id);
    }
}