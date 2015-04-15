package br.mackenzie.apd3.loja.dto;

import br.mackenzie.apd3.loja.model.ItemPedidoPK;

/**
 * Created by bweninger on 15/04/2015.
 */
public class ItemPedidoDTO {

    private ProdutoDTO produto;

    private PedidoDTO pedido;

    private Integer quantidade;

    private String comentario;

    private Integer avaliacao;

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }
}
