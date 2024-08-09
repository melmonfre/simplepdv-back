package com.restaurant.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
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

    @OneToMany(mappedBy = "restaurante")
    private List<FuncionarioEntity> funcionarios;

    @OneToMany(mappedBy = "restaurante")
    private List<ProdutosEntity> cardapio;

    @OneToMany(mappedBy = "restaurante")
    private List<InsumosEntity> insumos;

    @OneToMany(mappedBy = "restaurante")
    private List<VendaEntity> vendas;

    @OneToMany(mappedBy = "restaurante")
    private List<EstoqueEntity> itensEmEstoque;
}