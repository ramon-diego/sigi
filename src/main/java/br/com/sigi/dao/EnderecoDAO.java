package br.com.sigi.dao;

import br.com.sigi.domain.Endereco;

public class EnderecoDAO extends GenericDAO<Endereco, Long> {

	public EnderecoDAO(){
		
		super(Endereco.class);
	}
	
}
