package br.com.sigi.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sigi.model.AtributoImovel;
import br.com.sigi.model.Endereco;
import br.com.sigi.model.Imovel;
import br.com.sigi.model.Pessoa;

@ManagedBean(name = "imovelBean")
@ViewScoped
public class ImovelManagedBean {

	private Imovel imovel;
	private Pessoa proprietario;
	private Pessoa angariador;
	private Endereco endereco;
	private AtributoImovel atributoImovel;

	@PostConstruct
	public void init(){
		proprietario = new Pessoa();
		imovel = new Imovel();
		angariador = new Pessoa();
		endereco = new Endereco();
		atributoImovel = new  AtributoImovel();
	}
	
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	public Pessoa getAngariador() {
		return angariador;
	}

	public void setAngariador(Pessoa angariador) {
		this.angariador = angariador;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public AtributoImovel getAtributoImovel() {
		return atributoImovel;
	}
	public void setAtributoImovel(AtributoImovel atributoImovel) {
		this.atributoImovel = atributoImovel;
	}
}
