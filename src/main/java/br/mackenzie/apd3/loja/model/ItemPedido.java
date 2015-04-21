package br.mackenzie.apd3.loja.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoPK pk;

    private Integer quantidade;

    private String comentario;

    private Integer avaliacao;

    @Transient
    private Produto produto;

    @Transient
    private Pedido pedido;

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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        if (this.pk == null) {
            this.pk = new ItemPedidoPK();
            pk.setProduto(produto);
        }
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        if (this.pk == null) {
            this.pk = new ItemPedidoPK();
            pk.setPedido(pedido);
        }
        this.pedido = pedido;
    }

    public ItemPedidoPK getPk() {
        return pk;
    }

    public void setPk(ItemPedidoPK pk) {
        this.pk = pk;
    }
}
