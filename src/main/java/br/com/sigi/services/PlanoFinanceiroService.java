package br.com.sigi.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigi.model.PlanoFinanceiro;
import br.com.sigi.repositories.PlanoFinanceiroRepository;

@Service
public class PlanoFinanceiroService implements  Serializable {

	private static final long serialVersionUID = -3220314830911223294L;

	@Autowired
	private PlanoFinanceiroRepository planoFinanceiroRepository;
	
	public List<PlanoFinanceiro> findAll() {
		return planoFinanceiroRepository.findAll();
	}

	public void save(PlanoFinanceiro planoFinanceiro) {
		planoFinanceiroRepository.save(planoFinanceiro);
	}

	public List<PlanoFinanceiro> buscarPlanoDespesa() {

		return planoFinanceiroRepository.buscarPlanoDespesa();

	}

	public List<PlanoFinanceiro> buscarPlanoReceita() {

		return planoFinanceiroRepository.buscarPlanoReceita();
	}

	public List<PlanoFinanceiro> buscarPorId(Long id) {
		return planoFinanceiroRepository.findById(id);
	}

	public void delete(PlanoFinanceiro planoFinanceiro) {
		planoFinanceiroRepository.delete(planoFinanceiro);
	}
}
