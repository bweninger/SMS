package br.mackenzie.apd3.loja.dao.impl;

import br.mackenzie.apd3.loja.dao.CategoriaDAO;
import br.mackenzie.apd3.loja.model.Categoria;
import org.springframework.stereotype.Repository;

/**
 * Created by bweninger on 13/04/2015.
 */
@Repository
public class CategoriaDAOImpl extends GenericDAOImpl<Categoria, Long> implements CategoriaDAO {
}
