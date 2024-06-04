package com.restaurant.models.Produto;

import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Insumos.IsumersEntity;
import com.restaurant.models.Enums.Medida;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "produtos" )
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private double precoCusto;
    private double precoVenda;
    private boolean produtoEstoque;
    private List<IsumersEntity> ingredientes[];
    private Medida kilo = Medida.KG;
    private Medida unidade = Medida.UN;
    private Medida litro = Medida.L;
    private Medida mililitro = Medida.ML;
    private Categoria lanche = Categoria.LANCHE;
    private Categoria pizza = Categoria.PIZZA;
    private Categoria refeicao = Categoria.REFEICAO;
    private Categoria marmita = Categoria.MARMITA;
    private Categoria porcoes = Categoria.PORCOES;
    private Categoria sobremesa = Categoria.SOBREMESA;
    private Categoria refrigerante350ml = Categoria.REFRIGERANTE350ML;
    private Categoria refrigerante1l = Categoria.REFRIGERANTE1L;
    private Categoria refrigerante2l = Categoria.REFRIGERANTE2L;
    private Categoria suco = Categoria.SUCO;
    private Categoria cerveja300ml = Categoria.CERVEJA300ML;
    private Categoria cerveja600ml = Categoria.CERVEJA600ML;
}
