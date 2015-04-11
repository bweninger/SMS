package br.mackenzie.apd3.loja.dao.impl;

import br.mackenzie.apd3.loja.dao.ProdutoDAO;
import br.mackenzie.apd3.loja.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAOImpl extends GenericDAOImpl<Produto, Long> implements ProdutoDAO {

}
