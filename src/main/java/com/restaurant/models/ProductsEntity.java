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
    private Integer id;
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
    private List<InsumersEntity> ingredientes = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Medida medida;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public void addIngrediente(InsumersEntity insumersEntity) {
        this.ingredientes.add(insumersEntity);
    }
}
