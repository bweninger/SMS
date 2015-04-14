package br.mackenzie.apd3.loja.controller;

import br.mackenzie.apd3.loja.dto.ProdutoDTO;
import br.mackenzie.apd3.loja.model.Produto;
import br.mackenzie.apd3.loja.service.CategoriaService;
import br.mackenzie.apd3.loja.service.ProdutoService;
import br.mackenzie.apd3.loja.util.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ProdutoDTO> listarProdutos() {
		List<Produto> prods = this.produtoService.listarProdutos();
		return DTOUtil.converterLista(prods, ProdutoDTO.class);
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String incluirProduto(@RequestBody ProdutoDTO novoProduto){

		Produto produto = novoProduto.converterParaEntidade();
		this.produtoService.cadastrarProduto(produto);
		return "Sucesso";
	}
}
