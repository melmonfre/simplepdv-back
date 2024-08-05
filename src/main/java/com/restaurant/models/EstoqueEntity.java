package com.restaurant.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class EstoqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private RestauranteEntity restaurante;
    private ProdutosEntity produto;
    private InsumosEntity insumo;
    private double quantidadeMinima;
    private double quantidadeAtual;
    private LocalDateTime atualizacao;
}
