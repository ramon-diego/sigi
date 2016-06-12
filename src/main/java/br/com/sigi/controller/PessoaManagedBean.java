package br.com.sigi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import br.com.sigi.model.Cidade;
import br.com.sigi.model.Endereco;
import br.com.sigi.model.Pessoa;
import br.com.sigi.model.Telefone;
import br.com.sigi.services.PessoaService;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{pessoaService}")
	private PessoaService pessoaService;

	private Endereco endereco;
	private Telefone celular;
	private Telefone comercial;
	private Telefone residencial;

	private Cidade cidade;

	private Pessoa pessoa;

	private List<Pessoa> pessoas;

	private String cpfCnpj;
	private String nome;

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		pessoas = new ArrayList<>();
		celular = new Telefone();
		comercial = new Telefone();
		residencial = new Telefone();
		endereco = new Endereco();
		cidade = new Cidade();
	}

	public void pesquisarPessoas() {
		pessoas = pessoaService.pesquisarPessoas(getNome(), getCpfCnpj());
		// pessoas = pessoaService.pesquisarPessoas(getNome(), getCpfCnpj());
		// pessoas = pessoaService.findAll();
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public Telefone getCelular() {
		return celular;
	}

	public void setCelular(Telefone celular) {
		this.celular = celular;
	}

	public void setComercial(Telefone comercial) {
		this.comercial = comercial;
	}

	public Telefone getComercial() {
		return comercial;
	}

	public void setResidencial(Telefone residencial) {
		this.residencial = residencial;
	}

	public Telefone getResidencial() {
		return residencial;
	}

	public PessoaManagedBean() {

	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Transactional
	public void salvar() {

		try {
			endereco.setPessoa(pessoa);
			pessoa.getEnderecos().add(endereco);
			endereco.setCidade(cidade);
			pessoaService.save(pessoa);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	String arrivaleAirport = req.getParameter("arrivalAirport");

	private boolean renderFisica = true;
	private boolean renderJuridica = false;

	public void setRenderFisica(boolean renderFisica) {
		this.renderFisica = renderFisica;
		renderJuridica = false;
	}

	public void setRenderJuridica(boolean renderJuridica) {
		this.renderJuridica = renderJuridica;
		renderFisica = false;
	}

	public boolean isRenderFisica() {
		return renderFisica;
	}

	public boolean isRenderJuridica() {
		return renderJuridica;
	}

}
