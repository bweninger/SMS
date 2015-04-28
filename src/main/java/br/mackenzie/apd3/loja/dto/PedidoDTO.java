package br.mackenzie.apd3.loja.dto;

import br.mackenzie.apd3.loja.model.StatusPagamento;
import br.mackenzie.apd3.loja.model.StatusPedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by bweninger on 15/04/2015.
 */
public class PedidoDTO implements Serializable{

    private Long cdPedido;
    private StatusPedido status;
    private PagamentoDTO pagamento;
    private List<ItemPedidoDTO> itens;
    private ClienteDTO cliente;
    private EnderecoDTO enderecoEntrega;
    private Date dataPedido;

    public PedidoDTO() {
        this.status = StatusPedido.CARRINHO_DE_COMPRAS;
    }

    public Long getCdPedido() {
        return cdPedido;
    }

    public void setCdPedido(Long cdPedido) {
        this.cdPedido = cdPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<ItemPedidoDTO> getItens() {
        if (this.itens == null) {
            this.itens = new ArrayList<>();
        }
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemPedidoDTO itemPedidoDTO) {
        if (this.status == StatusPedido.CARRINHO_DE_COMPRAS) {
            this.getItens().add(itemPedidoDTO);
        } else {
            throw new IllegalStateException();
        }
    }

    public void fecharPedido() {
        if (status == StatusPedido.CARRINHO_DE_COMPRAS) {
            this.status = StatusPedido.AGUARDANDO_DADOS_ENTREGA;
        } else {
            throw new IllegalStateException();
        }
    }

    public PagamentoDTO getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoDTO pagamento) {
        this.pagamento = pagamento;
    }

    public BigDecimal calcularValorPedido() {
        BigDecimal valor = new BigDecimal("0.00");
        for (ItemPedidoDTO item : getItens()) {
            valor = valor.add(
                    item.getProduto().getPreco().multiply(
                            new BigDecimal(item.getQuantidade())));
        }
        return valor;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public Integer getQuantidadeItens() {
        Integer total = 0;
        for (ItemPedidoDTO item : getItens()) {
            total += item.getQuantidade();
        }
        return total;
    }

    public void pagarPorBoleto() {
        if (this.status == StatusPedido.AGUARDANDO_PAGAMENTO) {
            this.pagamento = new PagamentoBoletoDTO(calcularValorPedido(),
                    StatusPagamento.AGUARDANDO_AUTORIZACAO);
        } else {
            throw new IllegalStateException();
        }
    }

    public void pagarPorPagSeguro() {
        throw new UnsupportedOperationException();
    }

    public void pagarPorDebitoEmConta() {
        throw new UnsupportedOperationException();
    }

    public EnderecoDTO getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoDTO enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void incluirDadosEntrega(ClienteDTO cliente, EnderecoDTO endereco) {
        if (this.status == StatusPedido.AGUARDANDO_DADOS_ENTREGA) {
            this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
            this.cliente = cliente;
            this.enderecoEntrega = endereco;
        } else {
            throw new IllegalStateException();
        }
    }

    public Long gerarNumeroPedido() {
        if (this.status == StatusPedido.AGUARDANDO_PAGAMENTO) {
            Calendar cal = Calendar.getInstance();
            this.dataPedido = cal.getTime();
            StringBuilder codigoPedidoStr = new StringBuilder();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            codigoPedidoStr.append(sdf.format(this.dataPedido));
            codigoPedidoStr.append(this.cliente.getId());
            codigoPedidoStr.append(gerarCodigoItens());
            this.cdPedido = Long.parseLong(codigoPedidoStr.toString());
            return this.cdPedido;
        } else {
            throw new IllegalStateException();
        }
    }

    private Long gerarCodigoItens() {
        Long result = 0L;
        for (ItemPedidoDTO itemPedidoDTO : getItens()) {
            result += itemPedidoDTO.getProduto().getId() * itemPedidoDTO.getQuantidade();
        }
        return result;
    }

}
