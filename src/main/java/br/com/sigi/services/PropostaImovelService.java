package br.com.sigi.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigi.model.PropostaImovel;
import br.com.sigi.repositories.PropostaImovelRepository;

@Service
public class PropostaImovelService implements Serializable {

	private static final long serialVersionUID = 7361154205463062785L;
	@Autowired
	private PropostaImovelRepository pessoaRepository;

	public void save(PropostaImovel propostaImovel) {
		pessoaRepository.save(propostaImovel);
	}

}