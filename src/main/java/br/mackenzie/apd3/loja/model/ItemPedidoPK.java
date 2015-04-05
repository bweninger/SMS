package br.mackenzie.apd3.loja.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPK implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="idProduto", referencedColumnName="idProduto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="idPedido", referencedColumnName="cdPedido")
	private Pedido pedido;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
