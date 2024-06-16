package com.restaurant.models;

import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Enums.Medida;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "insumers")
@Data
public class InsumersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double preco;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Medida medida;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Integer quantidade;

}
