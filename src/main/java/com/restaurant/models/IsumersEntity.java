package com.restaurant.models;

import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Enums.Medida;
import jakarta.persistence.*;
import lombok.Data;



@Data
public class IsumersEntity {

    private double preco;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Medida medida;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

}
