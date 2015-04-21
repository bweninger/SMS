package br.mackenzie.apd3.loja.dao.impl;

import br.mackenzie.apd3.loja.dao.ClienteDAO;
import br.mackenzie.apd3.loja.model.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Created by BWeninger on 20/04/2015.
 */
@Repository
public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Long> implements ClienteDAO {


    @Override
    public Cliente buscarPorEmail(String email) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c from Cliente c ");
        sql.append("WHERE c.email like :email");
        TypedQuery<Cliente> query = this.entityManager.createQuery(sql.toString(), Cliente.class);
        query.setParameter("email", email);

        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("Usuario " + email + " nao cadastrado.");
            return null;
        }
    }

    @Override
    public Cliente buscarPorCPF(String cpf) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c from Cliente c ");
        sql.append("WHERE c.cpf like :cpf");
        TypedQuery<Cliente> query = this.entityManager.createQuery(sql.toString(), Cliente.class);
        query.setParameter("cpf", cpf);

        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("CPF " + cpf + " nao cadastrado.");
            return null;
        }
    }
}
