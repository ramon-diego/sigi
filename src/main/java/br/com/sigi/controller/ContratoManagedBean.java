package br.com.sigi.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.sigi.model.Contrato;
import br.com.sigi.model.Pessoa;
import br.com.sigi.services.ContratoService;

@ViewScoped
@ManagedBean(name = "contratoBean")
public class ContratoManagedBean implements Serializable {

	private static final long serialVersionUID = -99991648305545799L;

	private Pessoa locatario;
	private Pessoa proprietario;
	private Pessoa seguradora;
	private Pessoa fiador1;
	private Pessoa fiador2;
	private Contrato contrato;

	@ManagedProperty("#{contratoService}")
	private ContratoService contratoService;

	@PostConstruct
	public void init() {
		contrato = new Contrato();
		locatario = new Pessoa();
		proprietario = new Pessoa();
		seguradora = new Pessoa();
		fiador1 = new Pessoa();
		fiador2 = new Pessoa();

	}

	public void setContratoService(ContratoService contratoService) {
		this.contratoService = contratoService;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setLocatario(Pessoa locatario) {
		this.locatario = locatario;
	}

	public Pessoa getLocatario() {
		return locatario;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setSeguradora(Pessoa seguradora) {
		this.seguradora = seguradora;
	}

	public Pessoa getSeguradora() {
		return seguradora;
	}

	public Pessoa getFiador1() {
		return fiador1;
	}

	public void setFiador1(Pessoa fiador1) {
		this.fiador1 = fiador1;
	}

	public void setFiador2(Pessoa fiador2) {
		this.fiador2 = fiador2;
	}

	public Pessoa getFiador2() {
		return fiador2;
	}

	public void salvar() {
		if (contrato.getDataRegistro() == null) {
			contrato.setDataRegistro(new Date());
		}
		contratoService.save(contrato);
	}
}
