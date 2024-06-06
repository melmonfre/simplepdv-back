package com.restaurant.models;

import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Enums.Medida;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private double precoCusto;
    private double precoVenda;
    @ManyToMany
    @JoinTable(
            name = "products_insumers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "insumer_id")
    )
    private List<IsumersEntity> ingredientes = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Medida medida;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
