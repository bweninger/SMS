package br.mackenzie.apd3.loja.dto;

import br.mackenzie.apd3.loja.model.StatusPagamento;

import java.math.BigDecimal;

/**
 * Created by bweninger on 16/04/2015.
 */
public class PagamentoBoletoDTO extends PagamentoDTO {

    public PagamentoBoletoDTO(BigDecimal valor, StatusPagamento status) {
        super(valor, status);
    }

    public PagamentoBoletoDTO() {

    }
}
