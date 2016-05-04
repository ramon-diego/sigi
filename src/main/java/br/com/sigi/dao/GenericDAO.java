package br.com.sigi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sigi.utils.ConexaoDB;

public abstract class GenericDAO<T extends EntidadeBase> {

	private final EntityManager entityManager = ConexaoDB.getEntityManager();

	private Class<T> objeto;

	public GenericDAO(Class<T> objeto) {
		this.objeto = objeto;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void update(T objeto) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(objeto);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	public void salvar(T objeto) {

		try {
			entityManager.getTransaction().begin();
			if (objeto.getId() != null) {
				if (!entityManager.contains(objeto)) {
					if (entityManager.find(objeto.getClass(), objeto.getId()) == null) {
						System.out.println("Vou tratar posteriormente as exceções");
					}
				}
				objeto = entityManager.merge(objeto);
			} else {
				entityManager.persist(objeto);
			}
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
				e.printStackTrace();
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

	public void excluir(Long id) {

		excluir(getById(id));
	}

	public T getById(Long id) {

		return entityManager.find(objeto, id);
	}

	public List<T> findAll() {

		TypedQuery<T> query = entityManager.createQuery(" FROM " + objeto.getSimpleName(), objeto);
		return query.getResultList();
	}

	public void editar(Long id) {

		TypedQuery<T> query = getEntityManager().createQuery(" FROM " + objeto.getName(), objeto);
		query.getSingleResult();
	}
	

}