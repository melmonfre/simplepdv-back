package com.restaurant.models;

import java.math.BigDecimal;

public class Produto {

    private Long idProduto;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeDisponivel;    

    public Produto() {
    }

    public Produto(Long idProduto, String nome, String descricao, BigDecimal preco, Integer quantidadeDisponivel) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(final Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    } 

    public void setNome(final String nome) {
        this.nome = nome;
    } 

    public String getDescricao() {
        return descricao;
    } 

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(final BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(final Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((preco == null) ? 0 : preco.hashCode());
        result = prime * result + ((quantidadeDisponivel == null) ? 0 : quantidadeDisponivel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (idProduto == null) {
            if (other.idProduto != null)
                return false;
        } else if (!idProduto.equals(other.idProduto))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (preco == null) {
            if (other.preco != null)
                return false;
        } else if (!preco.equals(other.preco))
            return false;
        if (quantidadeDisponivel == null) {
            if (other.quantidadeDisponivel != null)
                return false;
        } else if (!quantidadeDisponivel.equals(other.quantidadeDisponivel))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
                + ", quantidadeDisponivel=" + quantidadeDisponivel + "]";
    }

}
