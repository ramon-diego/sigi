package br.com.sigi.dao;

import br.com.sigi.domain.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa, Long> {

	public PessoaDAO() {

		super(Pessoa.class);
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(pessoa);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
		return pessoa;
	}

	public Pessoa getPessoa() {

		return null;
	}

	public void updatePessoa(Pessoa pessoa) {

	}

	public void excluir(Long id) {

		try {
			getEntityManager().getTransaction().begin();
			Pessoa pessoa = getById(id);
			getEntityManager().remove(pessoa);
			getTransaction().commit();
		} finally {
			getEntityManager().close();
		}

	}

}
