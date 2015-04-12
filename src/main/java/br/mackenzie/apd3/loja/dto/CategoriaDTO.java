package br.mackenzie.apd3.loja.dto;

import br.mackenzie.apd3.loja.model.Categoria;

/**
 * Created by BWeninger on 11/04/2015.
 */
public class CategoriaDTO implements DataTransferObject<Categoria>{

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
}
