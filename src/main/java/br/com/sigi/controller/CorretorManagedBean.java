package br.com.sigi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.sigi.model.Pessoa;
import br.com.sigi.services.CorretorService;

@ViewScoped
@ManagedBean(name = "corretorBean")
public class CorretorManagedBean implements Serializable {


	private static final long serialVersionUID = 32386520074258890L;

	private List<Pessoa> corretores;
	@ManagedProperty("#{corretorService}")
	CorretorService corretorService;

	@PostConstruct
	public void init() {
		corretores = new ArrayList<>();
		pesquisarCorretor();
	}

	public void setCorretorService(CorretorService corretorService) {
		this.corretorService = corretorService;
	}

	public List<Pessoa> getCorretores() {
		return corretores;
	}

	public void setCorretores(List<Pessoa> corretores) {
		this.corretores = corretores;
	}

	public void pesquisarCorretor() {
		corretores = corretorService.pesquisarCorretor();
	}

}
