package br.com.sigi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.sigi.utils.ConexaoDB;

public abstract class GenericDAO2<T, K> {

	private final EntityManager entityManager = ConexaoDB.getEntityManager();

	private Class<T> objeto;

	public GenericDAO2(Class<T> objeto) {
		this.objeto = objeto;
	}

	public void close() {

		this.entityManager.close();
	}

	public EntityManager getEntityManager() {

		return this.entityManager;
	}

	public EntityTransaction getTransaction() {

		return entityManager.getTransaction();
	}

	public void update(T objeto) {
		getTransaction().begin();
		entityManager.merge(objeto);
		getTransaction().commit();
	}

	public void salvar(T objeto) {
		if (getEntityManager()==null) {
			getTransaction().begin();
			entityManager.merge(objeto);
			getTransaction().commit();
		} else {
			getTransaction().begin();
			entityManager.persist(objeto);
			getTransaction().commit();
			getEntityManager().close();
		}
	}

	public void excluir(T objeto) {
		getTransaction().begin();
		entityManager.remove(entityManager.merge(objeto));
		getTransaction().commit();
	}

	public List<T> findAll() {

		TypedQuery<T> query = entityManager.createQuery(" FROM " + objeto.getSimpleName(), objeto);
		return query.getResultList();
	}

	public T getById(Long id) {

		return entityManager.find(objeto, id);
	}

	public void excluir(Long id) {

		excluir(getById(id));
	}

}
