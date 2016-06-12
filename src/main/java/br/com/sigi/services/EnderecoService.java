package br.com.sigi.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigi.model.Endereco;
import br.com.sigi.repositories.EnderecoRepository;

@Service
public class EnderecoService implements Serializable {

	private static final long serialVersionUID = 6293157199560784954L;
	
//	@Autowired
	private EnderecoRepository enderecoRepository;

	public void save(Endereco endereco) {
		enderecoRepository.saveAndFlush(endereco);
	}
}
