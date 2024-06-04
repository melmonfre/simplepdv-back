package com.restaurant.models.Insumos;

import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Enums.Medida;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "insumos")
public class IsumersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double preco;
    private boolean produto;
    private String nome;
    private Medida kilo = Medida.KG;
    private Medida unidade = Medida.UN;
    private Medida litro = Medida.L;
    private Medida mililitro = Medida.ML;
    private Categoria bebidas = Categoria.BEBIDAS;
    private Categoria carnes = Categoria.CARNES;
    private Categoria condimentos = Categoria.CONDIMENTOS;
    private Categoria embalagens = Categoria.EMBALAGENS;
    private Categoria frios = Categoria.FRIOS;
    private Categoria leiteederivados = Categoria.LEITEEDERIVADOS;
    private Categoria liquidos = Categoria.LIQUIDOS;
    private Categoria massas = Categoria.MASSAS;
    private Categoria verduras = Categoria.VERDURAS;

}
