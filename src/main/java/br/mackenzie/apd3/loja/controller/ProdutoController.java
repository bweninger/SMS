package br.mackenzie.apd3.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.mackenzie.apd3.loja.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	@ResponseBody
	public String listarPedidos() {
		return "Listando Produtos";
	}
}
