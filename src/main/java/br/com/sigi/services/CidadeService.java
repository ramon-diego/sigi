package br.com.sigi.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigi.model.Cidade;
import br.com.sigi.repositories.CidadeRepository;

@Service
public class CidadeService implements Serializable {

	private static final long serialVersionUID = -3559377481291955491L;
	@Autowired
	private CidadeRepository cidadeRepository;

	public Cidade pesquisarCidadePorNome(String nome) {
		return cidadeRepository.findByNome(nome);
	}

}
