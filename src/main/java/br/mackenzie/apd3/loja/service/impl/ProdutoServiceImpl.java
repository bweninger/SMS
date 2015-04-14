package br.mackenzie.apd3.loja.service.impl;

import br.mackenzie.apd3.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mackenzie.apd3.loja.dao.ProdutoDAO;
import br.mackenzie.apd3.loja.service.ProdutoService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoDAO produtoDAO;


	@Override
	public List<Produto> listarProdutos() {
		return this.produtoDAO.listar();
	}

	@Override
	public void cadastrarProduto(Produto novoProduto) {
		this.produtoDAO.incluir(novoProduto);
	}
}
