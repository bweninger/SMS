package br.mackenzie.apd3.loja.dto;

import java.math.BigDecimal;

/**
 * Created by BWeninger on 16/05/2015.
 */
public class ProdutoRestDTO {

    private long codigo;
    private String imagem;
    private String nome;
    private BigDecimal preco;
    private String detalhes;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
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

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
