package com.restaurant.dtos;

import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Enums.Medida;
import com.restaurant.models.InsumosEntity;
import com.restaurant.models.RestauranteEntity;

public record DetalheInsumo(Long id,
                            RestauranteEntity restaurante,
                            Double preco,
                            String nome,
                            Medida medida,
                            Categoria categoria,
                            Integer quantidade) {
    public DetalheInsumo (InsumosEntity insumos){
      this(insumos.getId(), insumos.getRestaurante(), insumos.getPreco(), insumos.getNome(),
              insumos.getMedida(), insumos.getCategoria(), insumos.getQuantidade());
    }
}
