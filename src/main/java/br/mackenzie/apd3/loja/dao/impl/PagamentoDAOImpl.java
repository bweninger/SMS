package br.mackenzie.apd3.loja.dao.impl;

import br.mackenzie.apd3.loja.dao.PagamentoDAO;
import br.mackenzie.apd3.loja.model.Pagamento;
import org.springframework.stereotype.Repository;

/**
 * Created by BWeninger on 21/04/2015.
 */
@Repository
public class PagamentoDAOImpl extends GenericDAOImpl<Pagamento, Long> implements PagamentoDAO {
}
