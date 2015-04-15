package br.mackenzie.apd3.loja.dto;

import br.mackenzie.apd3.loja.model.StatusPagamento;

import java.math.BigDecimal;

/**
 * Created by bweninger on 15/04/2015.
 */
public class PagamentoDTO {
    
    private Long cdPagamento;
    private BigDecimal valor;
    private StatusPagamento status;

    public Long getCdPagamento() {
        return cdPagamento;
    }

    public void setCdPagamento(Long cdPagamento) {
        this.cdPagamento = cdPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public PagamentoDTO(BigDecimal valor, StatusPagamento status) {
        this.valor = valor;
        this.status = status;
    }

    public PagamentoDTO() {
    }
}
