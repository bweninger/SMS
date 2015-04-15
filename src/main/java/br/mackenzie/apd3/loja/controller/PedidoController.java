package br.mackenzie.apd3.loja.controller;

import br.mackenzie.apd3.loja.dto.ItemPedidoDTO;
import br.mackenzie.apd3.loja.dto.PedidoDTO;
import br.mackenzie.apd3.loja.model.Pedido;
import br.mackenzie.apd3.loja.util.DTOUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/pedidos")
@Scope("session")
public class PedidoController {

    private PedidoDTO pedidoDTO = new PedidoDTO();

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public String listarPedidos() {
        return "Listando Pedidos";
    }

    @RequestMapping(value = "/incluirProduto", method = RequestMethod.POST)
    @ResponseBody
    public PedidoDTO incluirProdutoCarrinho(@RequestBody ItemPedidoDTO item) {
        this.pedidoDTO.adicionarItem(item);
        return this.pedidoDTO;
    }

    @RequestMapping(value = "/finalizar",   method = RequestMethod.GET)
    @ResponseBody
    public PedidoDTO finalizarPedido() {
        this.pedidoDTO.finalizar();
        Pedido pedido = new Pedido();
        DTOUtil.copiarPropriedades(this.pedidoDTO, pedido, DTOUtil.obterNomesAtributos(PedidoDTO.class));
        return this.pedidoDTO;
    }
}
