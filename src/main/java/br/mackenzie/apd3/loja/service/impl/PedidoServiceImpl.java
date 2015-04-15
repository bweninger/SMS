package br.mackenzie.apd3.loja.service.impl;

import br.mackenzie.apd3.loja.dao.PedidoDAO;
import br.mackenzie.apd3.loja.model.Pedido;
import br.mackenzie.apd3.loja.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bweninger on 15/04/2015.
 */
@Service
@Transactional
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoDAO pedidoDao;

    @Override
    public void cadastrarPedido(Pedido pedido) {
        this.pedidoDao.incluir(pedido);
    }
}
