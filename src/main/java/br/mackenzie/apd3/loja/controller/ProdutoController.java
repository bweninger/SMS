package br.mackenzie.apd3.loja.controller;

import br.mackenzie.apd3.loja.dto.ProdutoDTO;
import br.mackenzie.apd3.loja.model.Produto;
import br.mackenzie.apd3.loja.service.ProdutoService;
import br.mackenzie.apd3.loja.util.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ProdutoDTO> listarProdutos() {
		List<Produto> prods = this.produtoService.listarProdutos();
		return DTOUtil.converterLista(prods, ProdutoDTO.class);
	}
}
