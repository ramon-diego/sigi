package br.com.sigi.dao;

import javax.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;
import br.com.sigi.domain.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa> implements Serializable {

	private static final long serialVersionUID = 1L;

	public PessoaDAO() {

		super(Pessoa.class);
	}

	public Pessoa buscarPorId(Long id) {

		try {
			getEntityManager();
			getEntityManager().getTransaction().begin();
			TypedQuery<Pessoa> query = getEntityManager().createNamedQuery("select Pessoa p where p.id = :id",
					Pessoa.class);
			query.setParameter("id", id);
			Pessoa pessoa = query.getSingleResult();
			getEntityManager().getTransaction().commit();
			return pessoa;
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			getEntityManager().close();
		}
		return null;
	}

	public List<Pessoa> buscarPorVariosAtributos(String nome, String cpfCnpj) {

		try {
			getEntityManager().getTransaction().begin();
			TypedQuery<Pessoa> query = getEntityManager().createQuery(
					"select p from Pessoa p where p.nomeFantasia like :nome and p.cpfCnpj like :cpfCnpj", Pessoa.class);
			// if (id != null) {
			// query.setParameter("id", id);
			// }

			if (nome != null) {
				query.setParameter("nome", "%" + nome + "%");
			}

			if (cpfCnpj != null) {
				query.setParameter("cpfCnpj", "%" + cpfCnpj + "%");
			}
			List<Pessoa> pessoas = query.getResultList();
			getEntityManager().getTransaction().commit();
			return pessoas;

		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			getEntityManager().close();
		}
		return null;
	}

}
