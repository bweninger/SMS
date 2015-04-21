package br.mackenzie.apd3.loja.dao;

import br.mackenzie.apd3.loja.model.Endereco;

import java.util.List;

/**
 * Created by BWeninger on 20/04/2015.
 */
public interface EnderecoDAO extends GenericDAO<Endereco, Long> {

    List<Endereco> listarPorCliente(Long idCliente);

}
