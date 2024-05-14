package com.restaurant.models;

import java.util.List;

public class Estoque {

    private Long idEstoque;
    private List<Produto> produtos;
    private Integer quantidadeAtual;

    public Estoque() {
    }

    public Estoque(Long idEstoque, Integer quantidadeAtual) {
        this.idEstoque = idEstoque;
        this.quantidadeAtual = quantidadeAtual;
    }

    public Long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(final Long idEstoque){
        this.idEstoque = idEstoque;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Integer getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(Integer quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idEstoque == null) ? 0 : idEstoque.hashCode());
        result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
        result = prime * result + ((quantidadeAtual == null) ? 0 : quantidadeAtual.hashCode());
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
        Estoque other = (Estoque) obj;
        if (idEstoque == null) {
            if (other.idEstoque != null)
                return false;
        } else if (!idEstoque.equals(other.idEstoque))
            return false;
        if (produtos == null) {
            if (other.produtos != null)
                return false;
        } else if (!produtos.equals(other.produtos))
            return false;
        if (quantidadeAtual == null) {
            if (other.quantidadeAtual != null)
                return false;
        } else if (!quantidadeAtual.equals(other.quantidadeAtual))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estoque [idEstoque=" + idEstoque + ", produtos=" + produtos + ", quantidadeAtual=" + quantidadeAtual
                + "]";
    }

}
