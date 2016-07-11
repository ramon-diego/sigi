package br.com.sigi.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigi.model.VistoriaImovel;
import br.com.sigi.repositories.VistoriaImovelRepository;

@Service
public class VistoriaImovelService implements Serializable {

	private static final long serialVersionUID = 1470447693310167398L;
	
	@Autowired
	VistoriaImovelRepository vistoriaRepository;

	public List<VistoriaImovel> findAll() {
		return vistoriaRepository.findAll();
	}

	public void save(VistoriaImovel vistoria) {
		vistoriaRepository.save(vistoria);
	}

}