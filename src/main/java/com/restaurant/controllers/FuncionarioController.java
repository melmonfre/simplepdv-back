package com.restaurant.controllers;

import com.restaurant.dtos.FuncionarioDTO;
import com.restaurant.services.ServicoFuncionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private ServicoFuncionarios servicoFuncionarios;

    @PostMapping("/criar")
    public FuncionarioDTO criarFuncionario(@RequestBody @Validated FuncionarioDTO funcionarioDTO){
        return servicoFuncionarios.criar(funcionarioDTO);
    }

    @GetMapping
    public List<FuncionarioDTO> listarFuncionarios(){
        return servicoFuncionarios.listarTodos();
    }

    @GetMapping("/{id}")
    public FuncionarioDTO pegarFuncionarioPorId(@PathVariable Long id){
        return servicoFuncionarios.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public FuncionarioDTO editarFuncionario(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO){
        return servicoFuncionarios.atualizar(id, funcionarioDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirFuncionario(@PathVariable Long id){
        servicoFuncionarios.deletar(id);
    }
}
