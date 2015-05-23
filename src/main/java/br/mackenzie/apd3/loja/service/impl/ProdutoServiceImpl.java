package br.mackenzie.apd3.loja.service.impl;

import br.mackenzie.apd3.loja.dto.ProdutoDTO;
import br.mackenzie.apd3.loja.dto.ProdutoRestDTO;
import br.mackenzie.apd3.loja.model.Produto;
import br.mackenzie.apd3.loja.util.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mackenzie.apd3.loja.dao.ProdutoDAO;
import br.mackenzie.apd3.loja.service.ProdutoService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public List<ProdutoRestDTO> listarProdutosRest() {
        List<ProdutoRestDTO> produtosRest = new ArrayList<>();
        List<Produto> list = this.produtoDAO.listar();
        for (Produto produto : list) {
			ProdutoRestDTO produtoRest = new ProdutoRestDTO();
            produtoRest.setCodigo(produto.getId());
            produtoRest.setDetalhes(produto.getDescricao());
            produtoRest.setImagem(produto.getUrlFoto());
            produtoRest.setNome(produto.getNome());
            produtoRest.setPreco(produto.getPreco());
            produtosRest.add(produtoRest);
        }

        return produtosRest;
    }

    @Override
    public ProdutoDTO detalharProduto(Long idProduto) {
        Produto produto = this.produtoDAO.buscarPorChave(idProduto);
        ProdutoDTO retorno = new ProdutoDTO();
        DTOUtil.copiarPropriedades(produto, retorno, DTOUtil.obterNomesAtributos(ProdutoDTO.class));
        return retorno;
    }
}
