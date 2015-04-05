package br.mackenzie.apd3.loja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatusPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStatusPagamento;
	private String descricao;

	public Long getIdStatusPagamento() {
		return idStatusPagamento;
	}

	public void setIdStatusPagamento(Long idStatusPagamento) {
		this.idStatusPagamento = idStatusPagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
