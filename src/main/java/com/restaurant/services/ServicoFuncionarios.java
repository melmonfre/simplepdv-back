package com.restaurant.services;

import com.restaurant.dtos.FuncionarioDTO;
import com.restaurant.dtos.mapper.FuncionarioMapper;
import com.restaurant.models.FuncionarioEntity;
import com.restaurant.models.RestauranteEntity;
import com.restaurant.repositories.FuncionarioRepository;
import com.restaurant.repositories.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServicoFuncionarios {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    public List<FuncionarioDTO> listarTodos() {
        List<FuncionarioEntity> funcionarios = this.funcionarioRepository.findAll();
        return funcionarios.stream()
                .map(this.funcionarioMapper::funcionarioEntityToFuncionarioDto)
                .toList();
    }

    public FuncionarioDTO buscarPorId(Long id) {
        FuncionarioEntity funcionarioEntity = this.funcionarioRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Funcionario não encontrado com o ID fornecido."));

        return this.funcionarioMapper.funcionarioEntityToFuncionarioDto(funcionarioEntity);
    }

    public FuncionarioDTO criar(FuncionarioDTO funcionarioDTO) {
        RestauranteEntity restaurante = this.restauranteRepository.findById(funcionarioDTO.restauranteId())
                .orElseThrow(() -> new NoSuchElementException("Restaurante não encontrado com o ID fornecido"));

        //QUANDO DISPONIVEL NO REPOSITÓRIO, LANÇAR EXCEÇÃO QUANDO FUNCIONARIO JA ESTIVER SIDO CRIADO

        FuncionarioEntity funcionarioEntity = this.funcionarioMapper.funcionarioDtoToFuncionarioEntity(funcionarioDTO);
        funcionarioEntity.setRestaurante(restaurante);
        FuncionarioEntity novoFuncionario = this.funcionarioRepository.save(funcionarioEntity);
        return this.funcionarioMapper.funcionarioEntityToFuncionarioDto(novoFuncionario);
    }

    public FuncionarioDTO atualizar(Long id, FuncionarioDTO funcionarioDTO) {
        FuncionarioEntity funcionarioExistente = this.funcionarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Funcionário não encontrado com o ID fornecido"));

        RestauranteEntity restaurante = this.restauranteRepository.findById(funcionarioDTO.restauranteId())
                .orElseThrow(() -> new NoSuchElementException("Restaurante não encontrado com o ID fornecido"));

        funcionarioExistente.setNome(funcionarioDTO.nome());
        funcionarioExistente.setSenha(funcionarioDTO.senha());
        funcionarioExistente.setRestaurante(restaurante);

        FuncionarioEntity funcionarioAtualizado = this.funcionarioRepository.save(funcionarioExistente);
        return this.funcionarioMapper.funcionarioEntityToFuncionarioDto(funcionarioAtualizado);
    }

    public void deletar(Long id) {
        this.funcionarioRepository.deleteById(id);
    }
}
