package br.com.sigi.services;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sigi.model.Contrato;
import br.com.sigi.repositories.ContratoRepository;

@Service
public class ContratoService implements Serializable {

	private static final long serialVersionUID = 2802137732371227713L;
	@Autowired
	private ContratoRepository contratoRepository;

	

	public void save(Contrato contrato) {
		contratoRepository.save(contrato);
	}

	public void delete(Contrato contrato) {
		contratoRepository.delete(contrato);
	}

}
