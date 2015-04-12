package br.mackenzie.apd3.loja.model;

import br.mackenzie.apd3.loja.dto.CategoriaDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria implements Entidade<CategoriaDTO>{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategoria;
	private String descricao;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaDTO converterParaDTO(){
		CategoriaDTO dto = new CategoriaDTO();
		dto.setDescricao(this.descricao);
		dto.setIdCategoria(this.idCategoria);
		return dto;
	}

}
