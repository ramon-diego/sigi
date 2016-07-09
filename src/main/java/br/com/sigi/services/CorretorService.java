package br.com.sigi.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigi.model.Pessoa;
import br.com.sigi.repositories.CorretorRepository;

@Service
public class CorretorService implements Serializable {

	private static final long serialVersionUID = 5475089498629892068L;

	@Autowired
	private CorretorRepository corretorRepository;

	public List<Pessoa> pesquisarCorretor() {
		return corretorRepository.pesquisarCorretor();
	}

}