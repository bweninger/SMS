package br.mackenzie.apd3.loja.test;

import br.mackenzie.apd3.loja.dto.*;
import br.mackenzie.apd3.loja.model.Pagamento;
import br.mackenzie.apd3.loja.model.PagamentoBoleto;
import br.mackenzie.apd3.loja.model.StatusPagamento;
import br.mackenzie.apd3.loja.util.DTOUtil;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by bweninger on 16/04/2015.
 */
public class TestePagamento {

    @Test
    public void testeConverterPagamento() {
        PagamentoDTO pagamentoDTO = new PagamentoBoletoDTO(new BigDecimal("50.00"),
                StatusPagamento.AGUARDANDO_AUTORIZACAO);

        Pagamento pagamento1 = new PagamentoBoleto();
        pagamento1.setStatus(StatusPagamento.PAGAMENTO_AUTORIZADO);
        pagamento1.setValor(new BigDecimal("50.00"));

        Pagamento pagamento2 = new PagamentoBoleto();
        DTOUtil.copiarPropriedades(pagamentoDTO, pagamento2, DTOUtil.obterNomesAtributos(Pagamento.class));

        assertTrue(!pagamento1.equals(pagamento2));

        pagamento1.setStatus(StatusPagamento.AGUARDANDO_AUTORIZACAO);
        assertTrue(pagamento1.equals(pagamento2));
    }

    @Test
    public void testePagarPorBoleto() {
        PedidoDTO pedidoDTO = criarPedido();
        pedidoDTO.fecharPedido();
        pedidoDTO.pagarPorBoleto();
        assertTrue(pedidoDTO.getPagamento() instanceof PagamentoBoletoDTO);
        assertEquals(new BigDecimal("147.00"), pedidoDTO.getPagamento().getValor());
        assertEquals(StatusPagamento.AGUARDANDO_AUTORIZACAO, pedidoDTO.getPagamento().getStatus());
    }

    private PedidoDTO criarPedido() {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(4L);
        produtoDTO.setPreco(new BigDecimal("49.00"));
        ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
        itemPedidoDTO.setProduto(produtoDTO);
        itemPedidoDTO.setQuantidade(3);
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.adicionarItem(itemPedidoDTO);
        return pedidoDTO;
    }

}
