package br.mackenzie.apd3.loja.builder;

import br.mackenzie.apd3.loja.dto.PagamentoBoletoDTO;
import br.mackenzie.apd3.loja.dto.PedidoDTO;
import br.mackenzie.apd3.loja.model.StatusPagamento;
import br.mackenzie.apd3.loja.model.StatusPedido;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.financeiro.banco.Banco;
import org.jrimum.domkee.financeiro.banco.febraban.*;

import javax.imageio.ImageIO;
import javax.swing.text.MaskFormatter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by BWeninger on 25/04/2015.
 */
public class BoletoBuilder {

    private PedidoDTO pedidoDTO;

    public BoletoBuilder(PedidoDTO pedidoDTO) {
        if (!(pedidoDTO.getPagamento() instanceof PagamentoBoletoDTO)) {
            throw new IllegalArgumentException();
        }

        if (pedidoDTO.getPagamento().getStatus() != StatusPagamento.AGUARDANDO_AUTORIZACAO
                && pedidoDTO.getStatus() != StatusPedido.AGUARDANDO_PAGAMENTO) {
            throw new IllegalStateException();
        }

        this.pedidoDTO = pedidoDTO;
    }

    public byte[] construirBoleto() {
        Cedente cedente = new Cedente("Loja APD3", "00.000.208/0001-00");

        Sacado sacado = new Sacado(pedidoDTO.getCliente().getNome(), adicionarMascaraCpf());

        Endereco enderecoSac = new Endereco();
        enderecoSac.setCep(new CEP(adicionarMascaraCep()));
        enderecoSac.setLogradouro(pedidoDTO.getEnderecoEntrega().getLogradouro());
        enderecoSac.setNumero(String.valueOf(pedidoDTO.getEnderecoEntrega().getNumero()));
        sacado.addEndereco(enderecoSac);

        ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_DO_BRASIL.create());
        contaBancaria.setAgencia(new Agencia(1234, "1"));
        contaBancaria.setNumeroDaConta(new NumeroDaConta(123456, "0"));
        contaBancaria.setCarteira(new Carteira(30));

        URL resource = getClass().getResource("/img/bb.jpg");
        Banco banco = contaBancaria.getBanco();
        try {
            banco.setImgLogo(ImageIO.read(resource));
        } catch (IOException e) {
            banco.setImgLogo(null);
            e.printStackTrace();
        }

        Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
        titulo.setNumeroDoDocumento("123456");
        titulo.setNossoNumero("99345678912");
        titulo.setDigitoDoNossoNumero("5");
        titulo.setValor(pedidoDTO.getPagamento().getValor());
        titulo.setDataDoDocumento(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 23);
        titulo.setDataDoVencimento(cal.getTime());
        titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
        titulo.setAceite(Titulo.Aceite.A);

        Boleto boleto = new Boleto(titulo);

        BoletoViewer viewer = new BoletoViewer(boleto);
        return viewer.getPdfAsByteArray();
    }

    private String adicionarMascaraCpf() {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(pedidoDTO.getCliente().getCpf());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String adicionarMascaraCep() {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("#####-###");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(pedidoDTO.getEnderecoEntrega().getCep());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
