package br.com.sigi.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class ConexaoDB {

	@PersistenceContext
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sigiPU");
	
	@SuppressWarnings("unused")
	private static EntityManager em;

	public static EntityManager getEntityManager(){
		
		return emf.createEntityManager();
	}
}
