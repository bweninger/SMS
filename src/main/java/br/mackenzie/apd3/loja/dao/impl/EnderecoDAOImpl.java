package br.mackenzie.apd3.loja.dao.impl;

import br.mackenzie.apd3.loja.dao.EnderecoDAO;
import br.mackenzie.apd3.loja.model.Endereco;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by BWeninger on 20/04/2015.
 */
@Repository
public class EnderecoDAOImpl extends GenericDAOImpl<Endereco, Long> implements EnderecoDAO {
    @Override
    public List<Endereco> listarPorCliente(Long idCliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT e FROM Endereco e ");
        sql.append("WHERE e.cliente.id = :idCliente");
        TypedQuery<Endereco> query = this.entityManager.createQuery(sql.toString(), Endereco.class);
        query.setParameter("idCliente", idCliente);
        return query.getResultList();
    }
}
