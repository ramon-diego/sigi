package br.com.sigi.dao;

import javax.persistence.TypedQuery;

import br.com.sigi.domain.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa, Long> {

	public PessoaDAO() {

		super(Pessoa.class);
	}

	public Pessoa getPessoa() {

		return null;
	}

	
	public Pessoa buscarPorNome(String nome){
		TypedQuery<Pessoa> query = getEntityManager().createQuery("FROM Pessoa o WHERE o.nome = :nome", Pessoa.class);
		query.setParameter("nome", nome);
		Pessoa pessoa = query.getSingleResult();
		return pessoa;
	}

}
