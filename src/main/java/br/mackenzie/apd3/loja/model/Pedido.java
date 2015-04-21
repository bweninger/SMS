package br.mackenzie.apd3.loja.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Pedido")
public class Pedido {
		
	@Id
	@Column(name = "cdPedido")
	private Long cdPedido;
	@ManyToOne
	@JoinColumn(name="idCliente", referencedColumnName="idCliente")
	private Cliente cliente;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "idStatusPedido")
	private StatusPedido status;
	@ManyToOne
	@JoinColumn(name="cdPagamento", referencedColumnName="cdPagamento")
	private Pagamento pagamento;
	private Date dataPedido;
	private Date dataPrevisaoEntrega;
	@ManyToOne
	@JoinColumn(name="idEndereco", referencedColumnName = "idEndereco")
	private Endereco enderecoEntrega;

	public Long getCdPedido() {
		return cdPedido;
	}

	public void setCdPedido(Long cdPedido) {
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

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco endereco) {
		this.enderecoEntrega = endereco;
	}
}
