package com.restaurant.models;

import java.math.BigDecimal;

import com.restaurant.enum.TipoProdutoEnum;

public class ItemPedido {

    private Long idItemPedido;
    private Pedido pedido;
    private Integer quantidade;
    private BigDecimal valorTotalItem;
    private Prato prato;
    private Bebida bebida;
    private TipoProdutoEnum tipoProduto;


    public ItemPedido() {
    }

    public ItemPedido(Long idItemPedido, Pedido pedido, Integer quantidade, BigDecimal valorTotalItem, Prato prato,
            Bebida bebida, TipoProdutoEnum tipoProduto) {
        this.idItemPedido = idItemPedido;
        this.pedido = pedido;
        this.quantidade = quantidade;
        this.valorTotalItem = valorTotalItem;
        this.prato = prato;
        this.bebida = bebida;
        this.tipoProduto = tipoProduto;
    }

    public Long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(final Long idItemPedido){
        this.idItemPedido = idItemPedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(final Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotalItem() {
        return valorTotalItem;
    }

    public void setValorTotalItem(final BigDecimal valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(final Prato prato) {
        this.prato = prato;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(final Bebida bebida) {
        this.bebida = bebida;
    }

    public TipoProdutoEnum getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(final TipoProdutoEnum tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}
