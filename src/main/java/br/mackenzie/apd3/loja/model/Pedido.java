package br.mackenzie.apd3.loja.model;

import java.util.Date;
import java.util.List;

public class Pedido {
	
	private long cdPedido;
	private Cliente cliente;
	private StatusPedido status;
	private List<ItemPedido> itens;
	private Pagamento pagamento;
	private Date dataPedido;
	private Date dataPrevisaoEntrega;
	
	public long getCdPedido() {
		return cdPedido;
	}
	public void setCdPedido(long cdPedido) {
		this.cdPedido = cdPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Date getDataPrevisaoEntrega() {
		return dataPrevisaoEntrega;
	}
	public void setDataPrevisaoEntrega(Date dataPrevisaoEntrega) {
		this.dataPrevisaoEntrega = dataPrevisaoEntrega;
	}

}
