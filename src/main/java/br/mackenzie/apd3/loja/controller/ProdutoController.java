package br.mackenzie.apd3.loja.controller;

import br.mackenzie.apd3.loja.dto.ProdutoDTO;
import br.mackenzie.apd3.loja.model.Produto;
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

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<ProdutoDTO> listarProdutos() {
        List<ProdutoDTO> listaDto = null;
        try {
            listaDto = DTOUtil.converterLista(this.produtoService.listarProdutos(),
                    ProdutoDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaDto;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ProdutoDTO cadastrarProduto(@RequestBody ProdutoDTO novoProduto) {
        Produto produto = new Produto();
        DTOUtil.copiarPropriedades(novoProduto, produto, DTOUtil.obterNomesAtributos(novoProduto.getClass()));
        this.produtoService.cadastrarProduto(produto);
        return novoProduto;
    }

}
