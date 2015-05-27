package br.mackenzie.apd3.loja.rest;

import br.mackenzie.apd3.loja.dto.ProdutoRestDTO;
import br.mackenzie.apd3.loja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by BWeninger on 16/05/2015.
 */
@RestController
@RequestMapping("/ws/produtos")
public class ProdutoRestController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<ProdutoRestDTO> listarProdutos() {
        List<ProdutoRestDTO> listaDto = this.produtoService.listarProdutosRest();
        return listaDto;
    }

}
