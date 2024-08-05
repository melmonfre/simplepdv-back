package com.restaurant.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProprietario;
    private String nomeRestaurante;
    private String telefone;
    private String email;
    private String senha;
    private String endereco;
    private String CNPJ;
    private List<FuncionarioEntity> funcionarios;
    private List<ProdutosEntity> cardapio;
    private List<InsumosEntity> insumos;
    private List<VendaEntity> vendas;
    private List<EstoqueEntity> itensEmEstoque;
}
