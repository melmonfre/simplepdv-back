package com.restaurant.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class EstoqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private RestauranteEntity restaurante;
    @ManyToOne
    private ProdutosEntity produto;
    @ManyToOne
    private InsumosEntity insumo;
    private double quantidadeMinima;
    private double quantidadeAtual;
    private LocalDateTime atualizacao;
}
