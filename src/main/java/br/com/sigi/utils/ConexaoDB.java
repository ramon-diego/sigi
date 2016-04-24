package br.com.sigi.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConexaoDB {

	private static EntityManagerFactory entityManagerFactory;

	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();

	public ConexaoDB() {

	}

	public static EntityManager getEntityManager() {

		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("sigiPU");

		}
		EntityManager entityManager = threadEntityManager.get();
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
			ConexaoDB.threadEntityManager.set(entityManager);
		}
		return entityManager;
	}

	public static void closeEntityManager() {

		EntityManager entityManager = threadEntityManager.get();

		if (entityManager != null) {
			EntityTransaction transaction = entityManager.getTransaction();

			if (transaction.isActive()) {
				transaction.commit();
			}
			entityManager.close();
			threadEntityManager.set(null);
		}
	}

	public static void closeEntityManagerFactory() {
		closeEntityManager();
		entityManagerFactory.close();
	}
}
