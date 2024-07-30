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
    //Restaurante
    private Long idProduto;
    private Long idInsumos;
    private String quantidadeMinima;
    private String quantidadeAtual;
    private LocalDateTime atualizacao;
}
