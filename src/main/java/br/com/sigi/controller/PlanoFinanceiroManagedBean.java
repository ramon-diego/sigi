package br.com.sigi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.sigi.model.PlanoFinanceiro;
import br.com.sigi.services.PlanoFinanceiroService;

@RequestScoped
@ManagedBean(name = "planoFinanceiroBean")
public class PlanoFinanceiroManagedBean implements Serializable {

	private static final long serialVersionUID = -7244080784034046663L;

	private PlanoFinanceiro planoFinanceiro;

	private List<PlanoFinanceiro> planosReceita;
	private List<PlanoFinanceiro> planosDespesa;

	@ManagedProperty("#{planoFinanceiroService}")
	PlanoFinanceiroService planoFinanceiroService;

	@PostConstruct
	public void init() {
		planoFinanceiro = new PlanoFinanceiro();
		planosDespesa = new ArrayList<>();
		planosDespesa = new ArrayList<>();
		carregarPlanos();
	}

	public void setPlanoFinanceiroService(PlanoFinanceiroService planoFinanceiroService) {
		this.planoFinanceiroService = planoFinanceiroService;
	}

	public void setPlanoFinanceiro(PlanoFinanceiro planoFinanceiro) {
		this.planoFinanceiro = planoFinanceiro;
	}

	public PlanoFinanceiro getPlanoFinanceiro() {
		return planoFinanceiro;
	}

	public void setPlanosReceita(List<PlanoFinanceiro> planosReceita) {
		this.planosReceita = planosReceita;
	}

	public List<PlanoFinanceiro> getPlanosReceita() {
		return planosReceita;
	}

	public void setPlanosDespesa(List<PlanoFinanceiro> planosDespesa) {
		this.planosDespesa = planosDespesa;
	}

	public List<PlanoFinanceiro> getPlanosDespesa() {
		return planosDespesa;
	}

	public void salvar() {
		planoFinanceiroService.save(planoFinanceiro);
		carregarPlanos();
	}
	public void delete(PlanoFinanceiro planoFinanceiro) {
		planoFinanceiroService.delete(planoFinanceiro);
		carregarPlanos();
	}

	public void carregarPlanos() {
		planosDespesa = planoFinanceiroService.buscarPlanoDespesa();
		planosReceita = planoFinanceiroService.buscarPlanoReceita();
	}

}
