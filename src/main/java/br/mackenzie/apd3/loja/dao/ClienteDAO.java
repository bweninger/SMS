package br.mackenzie.apd3.loja.dao;

import br.mackenzie.apd3.loja.model.Cliente;

/**
 * Created by BWeninger on 20/04/2015.
 */
public interface ClienteDAO extends GenericDAO<Cliente, Long> {

    Cliente buscarPorEmail(String email);

    Cliente buscarPorCPF(String cpf);
}
