package br.mackenzie.apd3.loja.rest;

import br.mackenzie.apd3.loja.dto.ProdutoRestDTO;
import br.mackenzie.apd3.loja.service.ProdutoService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
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
