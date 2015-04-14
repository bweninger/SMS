package br.mackenzie.apd3.loja.model;

import br.mackenzie.apd3.loja.dto.ProdutoDTO;

import java.math.BigDecimal;

import javax.persistence.*;

/**
 * 
 * Entidade Produto
 * 
 * @author Maciel
 *
 */

@Entity
@Table(name = "Produto")
public class Produto implements Entidade<ProdutoDTO> {

	@Id
	@Column(name = "idProduto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal preco;
	private String descricao;
	private String urlFoto;
	@ManyToOne
	@JoinColumn(name="idCategoria", referencedColumnName="idCategoria")
	private Categoria categoria;
	private Integer avaliacaoMedia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getAvaliacaoMedia() {
		return avaliacaoMedia;
	}

	public void setAvaliacaoMedia(int avaliacaoMedia) {
		this.avaliacaoMedia = avaliacaoMedia;
	}

	public ProdutoDTO converterParaDTO(){
		ProdutoDTO dto = new ProdutoDTO();
		dto.setAvaliacaoMedia(this.avaliacaoMedia);
		dto.setDescricao(this.descricao);
		dto.setId(this.id);
		dto.setNome(this.nome);
		dto.setPreco(this.preco);
		dto.setUrlFoto(this.urlFoto);
		dto.setCategoria(this.categoria.converterParaDTO());
		return dto;
	}

	
}
