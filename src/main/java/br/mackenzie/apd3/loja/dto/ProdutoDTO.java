package br.mackenzie.apd3.loja.dto;

import br.mackenzie.apd3.loja.model.Categoria;
import br.mackenzie.apd3.loja.model.Produto;

import java.math.BigDecimal;

/**
 * Created by BWeninger on 11/04/2015.
 */
public class ProdutoDTO {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String urlFoto;
    private CategoriaDTO categoria;
    private Integer avaliacaoMedia;

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

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

    public Integer getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public void setAvaliacaoMedia(Integer avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }

}
