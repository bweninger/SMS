package br.mackenzie.apd3.loja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cdCategoria;
	private String descricao;

	public Long getCdCategoria() {
		return cdCategoria;
	}

	public void setCdCategoria(Long cdCategoria) {
		this.cdCategoria = cdCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
