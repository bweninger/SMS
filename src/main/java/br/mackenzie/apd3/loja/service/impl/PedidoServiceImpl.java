package br.mackenzie.apd3.loja.service.impl;

import br.mackenzie.apd3.loja.dao.ItemPedidoDAO;
import br.mackenzie.apd3.loja.dao.PagamentoDAO;
import br.mackenzie.apd3.loja.dao.PedidoDAO;
import br.mackenzie.apd3.loja.dto.ItemPedidoDTO;
import br.mackenzie.apd3.loja.dto.PedidoDTO;
import br.mackenzie.apd3.loja.model.ItemPedido;
import br.mackenzie.apd3.loja.model.Pedido;
import br.mackenzie.apd3.loja.service.PedidoService;
import br.mackenzie.apd3.loja.util.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bweninger on 15/04/2015.
 */
@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDAO pedidoDao;

    @Autowired
    private ItemPedidoDAO itemPedidoDAO;

    @Autowired
    private PagamentoDAO pagamentoDAO;

    @Override
    public void cadastrarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        DTOUtil.copiarPropriedades(pedidoDTO, pedido, DTOUtil.obterNomesAtributos(Pedido.class));

        this.pagamentoDAO.incluir(pedido.getPagamento());

        this.pedidoDao.incluir(pedido);

        List<ItemPedido> itens = DTOUtil.converterLista(pedidoDTO.getItens(), ItemPedido.class);
        for (ItemPedido itemPedido : itens) {
            itemPedido.getPk().setPedido(pedido);
            this.itemPedidoDAO.incluir(itemPedido);
        }
    }

    @Override
    public PedidoDTO buscarPorCodigoPedido(Long codigoPedido) {
        Pedido pedido = this.pedidoDao.buscarPorChave(codigoPedido);
        PedidoDTO dto = new PedidoDTO();
        DTOUtil.copiarPropriedades(pedido, dto, DTOUtil.obterNomesAtributos(PedidoDTO.class));
        return dto;
    }
}
