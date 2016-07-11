package br.com.sigi.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.sigi.model.Imovel;
import br.com.sigi.model.Pessoa;
import br.com.sigi.model.PropostaImovel;
import br.com.sigi.services.PropostaImovelService;

@ManagedBean(name = "propostaImovelBean")
@ViewScoped
public class PropostaImovelManagedBean implements Serializable {

	private static final long serialVersionUID = -3631765621009314680L;

	private Pessoa proponente;

	private PropostaImovel propostaImovel;

	private Imovel imovel;

	@ManagedProperty("#{propostaImovelService}")
	private PropostaImovelService propostaImovelService;

	@PostConstruct
	public void init() {
		proponente = new Pessoa();
		imovel = new Imovel();
		propostaImovel = new PropostaImovel();
	}

	public void setPropostaImovelService(PropostaImovelService propostaImovelService) {
		this.propostaImovelService = propostaImovelService;
	}

	public void setProponente(Pessoa proponente) {
		this.proponente = proponente;
	}

	public Pessoa getProponente() {
		return proponente;
	}

	public void setPropostaImovel(PropostaImovel propostaImovel) {
		this.propostaImovel = propostaImovel;
	}

	public PropostaImovel getPropostaImovel() {
		return propostaImovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void validarProposta() {
		if (propostaImovel.getDataRegistro() == null) {
			propostaImovel.setDataRegistro(new Date());
		}
	}

	public void salvar() {
		try {
			validarProposta();
			propostaImovel.setProponente(proponente);
			propostaImovel.setImovel(imovel);
			propostaImovelService.save(propostaImovel);

		} catch (Exception e) {

		}
	}
}
