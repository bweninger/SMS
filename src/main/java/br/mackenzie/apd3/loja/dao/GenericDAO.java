package br.mackenzie.apd3.loja.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic Dao
 * 
 * @author Maciel
 *
 * @param <T>
 * @param <PK>
 */
public interface GenericDAO<T, PK extends Serializable> {

	T buscarPorChave(PK chave);

	List<T> listar();

	void incluir(T entidade);

	void excluir(T entidade);

	void atualizar(T entidade);

}
