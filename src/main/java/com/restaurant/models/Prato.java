package com.restaurant.models;

import java.math.BigDecimal;
import java.util.List;

    public class Prato {

        private Long idPrato;
        private String nome;
        private String descricao;
        private BigDecimal valor;
        private List<Produto> produtos;

    public Prato() {
    }

    public Prato(Long idPrato, String nome, String descricao, BigDecimal valor, List<Produto> produtos) {
        this.idPrato = idPrato;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.produtos = produtos;
    }

    public Long getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(final Long idPrato){
        this.idPrato = idPrato;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(final List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPrato == null) ? 0 : idPrato.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
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
        Prato other = (Prato) obj;
        if (idPrato == null) {
            if (other.idPrato != null)
                return false;
        } else if (!idPrato.equals(other.idPrato))
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
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        if (produtos == null) {
            if (other.produtos != null)
                return false;
        } else if (!produtos.equals(other.produtos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Prato [idPrato=" + idPrato + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor
                + ", produtos=" + produtos + "]";
    }

}
