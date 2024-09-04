package com.restaurant.models;

import com.restaurant.dtos.DetalheProduto;
import com.restaurant.models.Enums.Categoria;
import com.restaurant.models.Enums.Medida;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produtos")
@Data
public class ProdutosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private RestauranteEntity restaurante;
    private String nome;
    @Column(name = "preco_custo")
    private double precoCusto;
    @Column(name = "preco_venda")
    private double precoVenda;
    // Relação Many To Many (muitos ingredientes para muitos produtos)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "products_insumers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "insumer_id")
    )
    private List<InsumosEntity> ingredientes = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Medida medida;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public void addIngrediente(InsumosEntity insumosEntity) {
        this.ingredientes.add(insumosEntity);
    }

    public void alteraProduto(DetalheProduto dto){
        if (dto.restaurante() != null){
            this.restaurante = dto.restaurante();
        }
        if (dto.nome() != null){
            this.nome = dto.nome();
        }
        if (dto.precoCusto() != null){
            this.precoCusto = dto.precoCusto();
        }
        if (dto.precoVenda() != null){
            this.precoVenda = dto.precoVenda();
        }
        if (dto.medida() != null){
            this.medida = dto.medida();
        }
        if (dto.categoria() != null){
            this.categoria = dto.categoria();
        }
    }
}
