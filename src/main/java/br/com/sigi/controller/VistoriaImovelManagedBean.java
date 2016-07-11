package br.com.sigi.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.sigi.model.Imovel;
import br.com.sigi.model.Pessoa;
import br.com.sigi.model.VistoriaImovel;
import br.com.sigi.services.PessoaService;
import br.com.sigi.services.VistoriaImovelService;

@ManagedBean(name = "vistoriaImovelBean")
@ViewScoped
public class VistoriaImovelManagedBean implements Serializable {
	private static final long serialVersionUID = 8594043135145539362L;

	private Imovel imovel;
	private Pessoa vistoriador;
	private Pessoa inquilino;
	private VistoriaImovel vistoria;

	@ManagedProperty("#{vistoriaImovelService}")
	private VistoriaImovelService vistoriaImovelService;

	@ManagedProperty("#{pessoaService}")
	private PessoaService pessoaService;

	@PostConstruct
	public void init() {
		imovel = new Imovel();
		vistoriador = new Pessoa();
		inquilino = new Pessoa();
		vistoria = new VistoriaImovel();
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public void setVistoriaImovelService(VistoriaImovelService vistoriaImovelService) {
		this.vistoriaImovelService = vistoriaImovelService;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Pessoa getVistoriador() {
		return vistoriador;
	}

	public void setVistoriador(Pessoa vistoriador) {
		this.vistoriador = vistoriador;
	}

	public Pessoa getInquilino() {
		return inquilino;
	}

	public void setInquilino(Pessoa inquilino) {
		this.inquilino = inquilino;
	}

	public VistoriaImovel getVistoria() {
		return vistoria;
	}

	public void setVistoria(VistoriaImovel vistoria) {
		this.vistoria = vistoria;
	}

	public PessoaService getPessoaService() {
		return pessoaService;
	}

	public void validarVistoria() {
		if (vistoria.getDataRegistro() == null) {
			vistoria.setDataRegistro(new Date());
		}
	}

	public void salvar() {
		try {
			validarVistoria();
			vistoria.setImovel(imovel);
			vistoria.setInquilino(inquilino);
			vistoria.setVistoriador(vistoriador);
			vistoriaImovelService.save(vistoria);

		} catch (Exception e) {

		}
	}
}
