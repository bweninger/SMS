package br.mackenzie.apd3.loja.controller;

import br.mackenzie.apd3.loja.model.Produto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.mackenzie.apd3.loja.service.ProdutoService;

import java.util.List;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public String listarProdutos() {
		List<Produto> prods = this.produtoService.listarProdutos();
		Gson gson = new Gson();
		return gson.toJson(prods);
	}
}
