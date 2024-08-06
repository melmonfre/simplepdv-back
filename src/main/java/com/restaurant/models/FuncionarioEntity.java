package com.restaurant.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private RestauranteEntity restaurante;
    private String nome;
    private String email;
    private String senha;
}
