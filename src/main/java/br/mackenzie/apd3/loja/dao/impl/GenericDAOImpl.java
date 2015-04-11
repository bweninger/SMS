package br.mackenzie.apd3.loja.dao.impl;

import br.mackenzie.apd3.loja.dao.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by BWeninger on 11/04/2015.
 */
@Repository
public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {

    private Class<T> persistentClass;

    @Autowired
    protected HibernateTemplate hibernateTemplate;

    @Override
    public T buscarPorChave(PK chave) {
        return this.hibernateTemplate.get(getPersistentClass(), chave);
    }

    @Override
    public List<T> listar() {
        return this.hibernateTemplate.loadAll(getPersistentClass());
    }

    @Override
    public void incluir(T entidade) {
        this.hibernateTemplate.persist(entidade);
    }

    @Override
    public void excluir(T entidade) {
        this.hibernateTemplate.delete(entidade);
    }

    @Override
    public void atualizar(T entidade) {
        this.hibernateTemplate.merge(entidade);
    }

    private Class<T> getPersistentClass() {
        if (this.persistentClass == null) {
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return this.persistentClass;
    }
}
