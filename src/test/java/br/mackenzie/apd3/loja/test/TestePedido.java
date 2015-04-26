package br.mackenzie.apd3.loja.test;

import br.mackenzie.apd3.loja.dto.ItemPedidoDTO;
import br.mackenzie.apd3.loja.dto.PedidoDTO;
import br.mackenzie.apd3.loja.dto.ProdutoDTO;
import br.mackenzie.apd3.loja.model.ItemPedido;
import br.mackenzie.apd3.loja.model.Pedido;
import br.mackenzie.apd3.loja.service.PedidoService;
import br.mackenzie.apd3.loja.service.impl.PedidoServiceImpl;
import br.mackenzie.apd3.loja.util.DTOUtil;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.*;
import org.jrimum.domkee.financeiro.banco.febraban.*;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.imageio.ImageIO;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

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

        //assertEquals(pedido.getItens().size(), pedidoDTO.getItens().size());
        //assertEquals(pedido.getItens().get(0).getProduto().getPreco(), pedidoDTO.getItens().get(0).getProduto().getPreco());
    }

    @Test
    public void testeGerarBoleto() throws URISyntaxException, IOException {
        Cedente cedente = new Cedente("TESTE", "00.000.208/0001-00");

        Sacado sacado = new Sacado("Bruno Cesar Weninger","403.913.398-69");

        Endereco enderecoSac = new Endereco();
        enderecoSac.setUF(UnidadeFederativa.SP);
        enderecoSac.setLocalidade("Sao Paulo");
        enderecoSac.setCep(new CEP("59064-120"));
        enderecoSac.setBairro("Grande Centro");
        enderecoSac.setLogradouro("Rua poeta dos programas");
        enderecoSac.setNumero("1");
        sacado.addEndereco(enderecoSac);

        ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_BRADESCO.create());
        contaBancaria.setAgencia(new Agencia(1234, "1"));
        contaBancaria.setNumeroDaConta(new NumeroDaConta(123456, "0"));
        contaBancaria.setCarteira(new Carteira(30));

        URL resource = getClass().getResource("/img/bb.jpg");

        org.jrimum.domkee.financeiro.banco.Banco banco = contaBancaria.getBanco();
        banco.setImgLogo(ImageIO.read(resource));

        Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
        titulo.setNumeroDoDocumento("123456");
        titulo.setNossoNumero("99345678912");
        titulo.setDigitoDoNossoNumero("5");
        titulo.setValor(BigDecimal.valueOf(0.23));
        titulo.setDataDoDocumento(new Date());
        titulo.setDataDoVencimento(new Date());
        titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
        titulo.setAceite(Titulo.Aceite.A);
        titulo.setDesconto(new BigDecimal(0.05));
        titulo.setDeducao(BigDecimal.ZERO);
        titulo.setMora(BigDecimal.ZERO);
        titulo.setAcrecimo(BigDecimal.ZERO);
        titulo.setValorCobrado(BigDecimal.ZERO);

        Boleto boleto = new Boleto(titulo);

        File boletoArquivo = new BoletoViewer(boleto).getPdfAsFile("Boleto.pdf");

        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

        try {
            desktop.open(boletoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
