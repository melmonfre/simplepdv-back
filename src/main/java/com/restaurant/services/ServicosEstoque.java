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

    public DetalheEstoqueDTO criar(CriarEstoqueDTO estoqueDTO){
        try {

            EstoqueEntity estoqueEntity = estoqueMapper.criarEstoqueDtoParaEstoqueEntity(estoqueDTO);
            estoqueEntity.setAtualizacao(LocalDateTime.now());

            return estoqueMapper.estoqueEntityParaDetalheEstoqueDto(estoqueRepository.save(estoqueEntity));

        } catch (RuntimeException exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<DetalheEstoqueDTO> listar(){
        return estoqueRepository.findAll()
                .stream()
                .map(estoqueMapper::estoqueEntityParaDetalheEstoqueDto)
                .toList();
    }

    public DetalheEstoqueDTO pegarPorId(Long id){
        return estoqueMapper.estoqueEntityParaDetalheEstoqueDto(estoqueRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }

    public DetalheEstoqueDTO editar(Long id, CriarEstoqueDTO estoqueDTO){
        return estoqueRepository.findById(id).map(estoqueAtual -> {
            estoqueAtual.setRestaurante(estoqueDTO.restaurante());
            estoqueAtual.setProduto(estoqueDTO.produtosEntity());
            estoqueAtual.setInsumo(estoqueDTO.insumosEntity());
            estoqueAtual.setQuantidadeMinima(estoqueDTO.quantidadeMinima());
            estoqueAtual.setQuantidadeAtual(estoqueDTO.quantidadeAtual());
            estoqueAtual.setAtualizacao(LocalDateTime.now());
            return estoqueMapper.estoqueEntityParaDetalheEstoqueDto(estoqueRepository.save(estoqueAtual));
        }).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    public void excluir(Long id) {
        estoqueRepository.delete(estoqueRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }
}
