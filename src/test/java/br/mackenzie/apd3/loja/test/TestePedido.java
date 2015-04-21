package br.mackenzie.apd3.loja.test;

import br.mackenzie.apd3.loja.dto.ItemPedidoDTO;
import br.mackenzie.apd3.loja.dto.PedidoDTO;
import br.mackenzie.apd3.loja.dto.ProdutoDTO;
import br.mackenzie.apd3.loja.model.ItemPedido;
import br.mackenzie.apd3.loja.model.Pedido;
import br.mackenzie.apd3.loja.service.PedidoService;
import br.mackenzie.apd3.loja.service.impl.PedidoServiceImpl;
import br.mackenzie.apd3.loja.util.DTOUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

/**
 * Created by bweninger on 16/04/2015.
 */
public class TestePedido {

    private static PedidoService service;

    @BeforeClass
    public static void iniciar(){
        service = new PedidoServiceImpl();
    }

    @Test
    public void testeIncluirProduto(){
        ItemPedidoDTO itemPedidoDTO = criarItemPedido();
        PedidoDTO pedidoDTO = new PedidoDTO();
        assertTrue(pedidoDTO.getQuantidadeItens() == 0);
        pedidoDTO.adicionarItem(itemPedidoDTO);
        assertTrue(pedidoDTO.getQuantidadeItens() == 3);
    }

    @Test
    public void testeCalcularValor(){
        ItemPedidoDTO itemPedidoDTO = criarItemPedido();
        PedidoDTO pedidoDTO = new PedidoDTO();
        assertEquals(new BigDecimal("0.00"), pedidoDTO.calcularValorPedido());
        pedidoDTO.adicionarItem(itemPedidoDTO);
        assertEquals(new BigDecimal("147.00"), pedidoDTO.calcularValorPedido());
    }

    private ItemPedidoDTO criarItemPedido(){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(4L);
        produtoDTO.setPreco(new BigDecimal("49.00"));
        ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
        itemPedidoDTO.setProduto(produtoDTO);
        itemPedidoDTO.setQuantidade(3);
        return itemPedidoDTO;
    }

    @Test
    public void testeConverterPedido(){
        ItemPedidoDTO itemPedidoDTO = criarItemPedido();
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.adicionarItem(itemPedidoDTO);

        Pedido pedido = new Pedido();
        DTOUtil.copiarPropriedades(pedidoDTO, pedido, DTOUtil.obterNomesAtributos(Pedido.class));

        assertEquals(pedido.getItens().size(), pedidoDTO.getItens().size());
        assertEquals(pedido.getItens().get(0).getProduto().getPreco(), pedidoDTO.getItens().get(0).getProduto().getPreco());
    }
}
