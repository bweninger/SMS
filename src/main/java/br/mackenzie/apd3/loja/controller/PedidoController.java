package br.mackenzie.apd3.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/pedidos")
public class PedidoController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	@ResponseBody
	public String listarPedidos() {
		return "Listando Pedidos";
	}
}
