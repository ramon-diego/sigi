package br.com.sigi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigi.model.Imovel;
import br.com.sigi.repositories.ImovelRepository;

@Service
public class ImovelService {

	@Autowired
	ImovelRepository imovelRepository;

	public void salvar(Imovel imovel) {
		imovelRepository.save(imovel);
	}
}
