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
    private Integer id;
    @Column
    private double preco;
    @Column
    private String nome;
    @Column
    @Enumerated(EnumType.STRING)
    private Medida medida;
    @Column
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Integer quantidade;


}
