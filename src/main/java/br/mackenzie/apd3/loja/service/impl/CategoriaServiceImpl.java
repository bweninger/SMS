package br.mackenzie.apd3.loja.service.impl;

import br.mackenzie.apd3.loja.dao.CategoriaDAO;
import br.mackenzie.apd3.loja.model.Categoria;
import br.mackenzie.apd3.loja.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bweninger on 13/04/2015.
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public void cadastrarCategoria(Categoria categoria) {
        this.categoriaDAO.incluir(categoria);
    }
}
