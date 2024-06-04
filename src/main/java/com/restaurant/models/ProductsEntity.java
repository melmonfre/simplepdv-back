package com.restaurant.models;

import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Enums.Medida;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ProductsEntity {

    private String nome;
    private double precoCusto;
    private double precoVenda;
    private List<IsumersEntity> ingredientes = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Medida medida;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
