package br.com.sigi.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigi.model.ExclusividadeImovel;
import br.com.sigi.repositories.ExclusivdadeImovelRepository;

@Service
public class ExclusividadeImovelService implements Serializable {

	private static final long serialVersionUID = 9142744096591345436L;

	@Autowired
	ExclusivdadeImovelRepository exclusividadeImovelRepository;

	public void salvar(ExclusividadeImovel ExclusividadeImovel) {
		exclusividadeImovelRepository.save(ExclusividadeImovel);
	}
}
