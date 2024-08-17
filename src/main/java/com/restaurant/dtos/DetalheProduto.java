package com.restaurant.dtos;

import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Enums.Medida;
import com.restaurant.models.InsumosEntity;
import com.restaurant.models.ProdutosEntity;
import com.restaurant.models.RestauranteEntity;

import java.util.List;

public record DetalheProduto(Long id,
                             RestauranteEntity restaurante,
                             String nome,
                             Double precoCusto,
                             Double precoVenda,
                             List<InsumosEntity> ingredientes,
                             Medida medida,
                             Categoria categoria) {
    public DetalheProduto(ProdutosEntity produto){
        this(produto.getId(), produto.getRestaurante(), produto.getNome(), produto.getPrecoCusto(), produto.getPrecoVenda(),
                produto.getIngredientes(), produto.getMedida(), produto.getCategoria());
    }
}
