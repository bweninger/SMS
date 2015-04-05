package br.mackenzie.apd3.loja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatusPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStatusPedido;
	private String descricao;

	public Long getIdStatusPedido() {
		return idStatusPedido;
	}

	public void setIdStatusPedido(Long idStatusPedido) {
		this.idStatusPedido = idStatusPedido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
