package com.restaurant.models;

import com.restaurant.dtos.DetalheInsumo;
import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Enums.Medida;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "insumos")
@Data
public class InsumosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private RestauranteEntity restaurante;
    private double preco;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Medida medida;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Integer quantidade;

    public void alteraInsumo (DetalheInsumo dto){
        if (dto.restaurante() != null){
            this.restaurante = dto.restaurante();
        }
        if (dto.preco() != null){
            this.preco = dto.preco();
        }
        if (dto.nome() != null){
            this.nome = dto.nome();
        }
        if (dto.medida() != null){
            this.medida = dto.medida();
        }
        if (dto.categoria() != null){
            this.categoria = dto.categoria();
        }
        if (dto.quantidade() != null){
            this.quantidade =  dto.quantidade();
        }
    }

}
