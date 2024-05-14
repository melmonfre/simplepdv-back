package com.restaurant.models;

import com.restaurant.enum.StatusPedidoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private Long idPedido;
    private LocalDateTime dataHora;
    private StatusPedidoEnum status;
    private BigDecimal valorTotal;
    private Produto produto;
    private List<ItemPedido> itemPedido;
    
    public Pedido() {
    }

    public Pedido(Long idPedido, LocalDateTime dataHora, StatusPedidoEnum status, BigDecimal valorTotal,
            Produto produto, List<ItemPedido> itemPedido) {
        this.idPedido = idPedido;
        this.dataHora = dataHora;
        this.status = status;
        this.valorTotal = valorTotal;
        this.produto = produto;
        this.itemPedido = itemPedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(final Long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(final LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(final BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedidoEnum getStatus(){
        return status;
    }

    public void setStatus(final StatusPedidoEnum status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(final Produto produto) {
        this.produto = produto;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(final List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
        result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
        result = prime * result + ((itemPedido == null) ? 0 : itemPedido.hashCode());
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
        Pedido other = (Pedido) obj;
        if (idPedido == null) {
            if (other.idPedido != null)
                return false;
        } else if (!idPedido.equals(other.idPedido))
            return false;
        if (dataHora == null) {
            if (other.dataHora != null)
                return false;
        } else if (!dataHora.equals(other.dataHora))
            return false;
        if (status != other.status)
            return false;
        if (valorTotal == null) {
            if (other.valorTotal != null)
                return false;
        } else if (!valorTotal.equals(other.valorTotal))
            return false;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        if (itemPedido == null) {
            if (other.itemPedido != null)
                return false;
        } else if (!itemPedido.equals(other.itemPedido))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", dataHora=" + dataHora + ", status=" + status + ", valorTotal="
                + valorTotal + ", produto=" + produto + ", itemPedido=" + itemPedido + "]";
    }

}
