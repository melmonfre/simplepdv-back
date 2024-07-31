package com.restaurant.models;

import com.restaurant.models.Enums.FormaDePagamento;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
public class VendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Restaurante
    private FuncionarioEntity funcionario;
    private List<ProdutosEntity> produtos;
    private Double somaTotalDaListaDeProdutos;
    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaDePagamento;
    private LocalDateTime dataDaVenda;
}
