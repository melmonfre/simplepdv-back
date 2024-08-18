package com.restaurant.services;

import com.restaurant.dtos.CriarEstoqueDTO;
import com.restaurant.dtos.DetalheEstoqueDTO;
import com.restaurant.dtos.mapper.EstoqueMapper;
import com.restaurant.models.EstoqueEntity;
import com.restaurant.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicosEstoque {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private EstoqueMapper estoqueMapper;

    public DetalheEstoqueDTO criarEstoque(CriarEstoqueDTO estoqueDTO){
        try {

            EstoqueEntity estoqueEntity = estoqueMapper.criarEstoqueDtoParaEstoqueEntity(estoqueDTO);
            estoqueEntity.setAtualizacao(LocalDateTime.now());

            return estoqueMapper.estoqueEntityParaDetalheEstoqueDto(estoqueRepository.save(estoqueEntity));

        } catch (RuntimeException exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<DetalheEstoqueDTO> listarEstoque(){
        return estoqueRepository.findAll()
                .stream()
                .map(estoqueMapper::estoqueEntityParaDetalheEstoqueDto)
                .toList();
    }

    public DetalheEstoqueDTO pegarEstoquePorId(Long id){
        return estoqueMapper.estoqueEntityParaDetalheEstoqueDto(estoqueRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }

    public DetalheEstoqueDTO editarEstoque(Long id, CriarEstoqueDTO estoqueDTO){
        return estoqueRepository.findById(id).map(estoqueAtual -> {
            if(estoqueDTO.restaurante() != null) estoqueAtual.setRestaurante(estoqueDTO.restaurante());
            if(estoqueDTO.produtosEntity() != null) estoqueAtual.setProduto(estoqueDTO.produtosEntity());
            if(estoqueDTO.insumosEntity() != null) estoqueAtual.setInsumo(estoqueDTO.insumosEntity());
            if(estoqueDTO.quantidadeMinima() > 0.0) estoqueAtual.setQuantidadeMinima(estoqueDTO.quantidadeMinima());
            if(estoqueDTO.quantidadeAtual() != null) estoqueAtual.setQuantidadeAtual(estoqueDTO.quantidadeAtual());
            estoqueAtual.setAtualizacao(LocalDateTime.now());
            return estoqueMapper.estoqueEntityParaDetalheEstoqueDto(estoqueRepository.save(estoqueAtual));
        }).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    public void excluirEstoque(Long id) {
        estoqueRepository.delete(estoqueRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }
}
