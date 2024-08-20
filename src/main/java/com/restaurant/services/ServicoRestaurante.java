package com.restaurant.services;

import com.restaurant.dtos.RestauranteDTO;
import com.restaurant.dtos.mapper.RestauranteMapper;
import com.restaurant.models.RestauranteEntity;
import com.restaurant.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServicoRestaurante {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private InsumosRepository insumosRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private RestauranteMapper restauranteMapper;

    public List<RestauranteDTO> listarTodos() {
        List<RestauranteEntity> restaurantes = this.restauranteRepository.findAll();
        return restaurantes.stream()
                .map(this.restauranteMapper::restauranteEntitytoRestauranteDTO)
                .toList();
    }

    public RestauranteDTO buscarPorId(Long id) {
        RestauranteEntity restauranteEntity = this.restauranteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Restaurante não encontrado com o ID fornecido"));
        return this.restauranteMapper.restauranteEntitytoRestauranteDTO(restauranteEntity);
    }

    @Transactional
    public RestauranteDTO criar(RestauranteDTO restauranteDTO) {
        RestauranteEntity restauranteEntity = this.restauranteMapper.restauranteDTOtoRestauranteEntity(restauranteDTO);

        // setando as entidades relacionadas usando os IDs passados no DTO
        restauranteEntity.setFuncionarios(this.funcionarioRepository.findAllById(restauranteDTO.funcionariosIds()));
        restauranteEntity.setCardapio(this.produtosRepository.findAllById(restauranteDTO.cardapioIds()));
        restauranteEntity.setInsumos(this.insumosRepository.findAllById(restauranteDTO.insumosIds()));
        restauranteEntity.setVendas(this.vendaRepository.findAllById(restauranteDTO.vendasIds()));
        restauranteEntity.setItensEmEstoque(this.estoqueRepository.findAllById(restauranteDTO.itensEmEstoqueIds()));

        RestauranteEntity savedRestaurante = this.restauranteRepository.save(restauranteEntity);
        return this.restauranteMapper.restauranteEntitytoRestauranteDTO(savedRestaurante);
    }

    @Transactional
    public RestauranteDTO atualizar(Long id, RestauranteDTO restauranteDTO) {
        RestauranteEntity restauranteEntity = this.restauranteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Restaurante não encontrado com o ID fornecido"));

        restauranteEntity.setNomeProprietario(restauranteDTO.nomeProprietario());
        restauranteEntity.setNomeRestaurante(restauranteDTO.nomeRestaurante());
        restauranteEntity.setTelefone(restauranteDTO.telefone());
        restauranteEntity.setEmail(restauranteDTO.email());
        restauranteEntity.setSenha(restauranteDTO.senha());
        restauranteEntity.setEndereco(restauranteDTO.endereco());
        restauranteEntity.setCNPJ(restauranteDTO.CNPJ());

        restauranteEntity.setFuncionarios(this.funcionarioRepository.findAllById(restauranteDTO.funcionariosIds()));
        restauranteEntity.setCardapio(this.produtosRepository.findAllById(restauranteDTO.cardapioIds()));
        restauranteEntity.setInsumos(this.insumosRepository.findAllById(restauranteDTO.insumosIds()));
        restauranteEntity.setVendas(this.vendaRepository.findAllById(restauranteDTO.vendasIds()));
        restauranteEntity.setItensEmEstoque(this.estoqueRepository.findAllById(restauranteDTO.itensEmEstoqueIds()));

        RestauranteEntity restauranteAtualizado = this.restauranteRepository.save(restauranteEntity);
        return this.restauranteMapper.restauranteEntitytoRestauranteDTO(restauranteAtualizado);
    }

    public void deletar(Long id) {
        this.restauranteRepository.deleteById(id);
    }
}
