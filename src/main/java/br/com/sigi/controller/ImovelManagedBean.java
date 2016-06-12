package br.com.sigi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.sigi.model.AtributoImovel;
import br.com.sigi.model.Cidade;
import br.com.sigi.model.Endereco;
import br.com.sigi.model.Imovel;
import br.com.sigi.model.Pessoa;
import br.com.sigi.services.ImovelService;
import br.com.sigi.services.PessoaService;

@ManagedBean(name = "imovelBean")
@ViewScoped
public class ImovelManagedBean implements Serializable {

	private static final long serialVersionUID = 6729233648580056599L;
	private Imovel imovel;
	private Pessoa proprietario;
	private List<Pessoa> pessoas;
	private Pessoa angariador;
	private Endereco endereco;
	private Cidade cidade;
	private AtributoImovel atributoImovel;

	@PostConstruct
	public void init() {
		proprietario = new Pessoa();
		imovel = new Imovel();
		angariador = new Pessoa();
		endereco = new Endereco();
		atributoImovel = new AtributoImovel();
		pessoas = new ArrayList<>();
		cidade = new Cidade();

	}

	@ManagedProperty("#{imovelService}")
	private ImovelService imovelService;

	@ManagedProperty("#{pessoaService}")
	private PessoaService pessoaService;

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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setImovelService(ImovelService imovelService) {
		this.imovelService = imovelService;
	}

	public AtributoImovel getAtributoImovel() {
		return atributoImovel;
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public void setAtributoImovel(AtributoImovel atributoImovel) {
		this.atributoImovel = atributoImovel;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	private String nome;
	private String cpfCnpj;

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void pesquisarPessoas() {
		pessoas = pessoaService.pesquisarPessoas(getNome(), getCpfCnpj());
	}

	public void registraProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	public void salvar() {
		try {
			imovel.setAtributoImovel(atributoImovel);
			imovel.setProprietario(proprietario);
			imovel.setEndereco(endereco);
			imovelService.salvar(imovel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
