package br.mackenzie.apd3.loja.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic Dao
 * @author Maciel
 *
 * @param <T>
 * @param <Type>
 */
public interface GenericDAO<T,Type extends Serializable> {

	public T buscarPorChave(T chave);
	public List<T> listar();
	public void incluir();
	public void excluir();
	public void atualizar();

}
