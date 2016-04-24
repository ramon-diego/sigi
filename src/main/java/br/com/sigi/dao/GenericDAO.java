package br.com.sigi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.sigi.utils.ConexaoDB;

public abstract class GenericDAO<T, K> {

	private final EntityManager entityManager = ConexaoDB.getEntityManager();

	private Class<T> objeto;

	public GenericDAO(Class<T> objeto) {
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
		try {
			getTransaction().begin();
			entityManager.merge(objeto);
			getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	public void salvar(T objeto) {

		try {
			getTransaction().begin();
			entityManager.persist(objeto);
			entityManager.getTransaction().commit();
			getEntityManager().close();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	public void excluir(T objeto) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(objeto);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
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