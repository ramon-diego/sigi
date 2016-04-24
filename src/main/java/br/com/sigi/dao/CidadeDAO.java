package br.com.sigi.dao;

import br.com.sigi.domain.Cidade;

public class CidadeDAO extends GenericDAO<Cidade, Long> {

	public CidadeDAO(){
		
		super(Cidade.class);
	}
}
