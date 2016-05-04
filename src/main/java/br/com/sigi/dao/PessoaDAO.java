package br.com.sigi.dao;

import javax.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;
import br.com.sigi.domain.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa> implements Serializable{

	private static final long serialVersionUID = 1L;


	public PessoaDAO() {

		super(Pessoa.class);
	}

	public Pessoa getPessoa() {

		return null;
	}

	public List<Pessoa> buscarPorVariosAtributos(String filtro) {

		try {
			getEntityManager();
			getEntityManager().getTransaction().begin();
			TypedQuery<Pessoa> query = getEntityManager().createNamedQuery(Pessoa.BUSCAR_POR_VARIOS_ATRIBUTOS,
					Pessoa.class);
			query.setParameter("nome", "%" + filtro + "%").setParameter("cpfCnpj", "%" + filtro + "%");
			List<Pessoa> pessoas = query.getResultList();
			getEntityManager().getTransaction().commit();
			return pessoas;
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			getEntityManager().close();
		}
		return null;
	}

	public Pessoa pesquisar(Long id) {
		getEntityManager();
		getEntityManager().getTransaction().begin();
		TypedQuery<Pessoa> query = getEntityManager().createQuery("select p from Pessoa p where p.id = :id", Pessoa.class);
		query.setParameter("id", id);
		getEntityManager().getTransaction().commit();
		Pessoa pessoa = query.getSingleResult();
		return pessoa;
	}
	
	
	public Pessoa buscarPorId(Long id) {
		getEntityManager().getTransaction().begin();
		Pessoa pessoa = getEntityManager().find(Pessoa.class, id);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
		return pessoa;
	}

	
}
