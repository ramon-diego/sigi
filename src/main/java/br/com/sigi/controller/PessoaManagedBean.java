package br.com.sigi.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.transaction.annotation.Transactional;

import br.com.sigi.model.Cidade;
import br.com.sigi.model.Endereco;
import br.com.sigi.model.Pessoa;
import br.com.sigi.model.Telefone;
import br.com.sigi.services.CidadeService;
import br.com.sigi.services.PessoaService;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaManagedBean implements Serializable {

	private static final long serialVersionUID = -8547411202619341413L;

	@ManagedProperty("#{pessoaService}")
	private PessoaService pessoaService;

	@ManagedProperty("#{cidadeService}")
	private CidadeService cidadeService;

	private Endereco endereco;
	private Telefone celular;
	private Telefone comercial;
	private Telefone residencial;

	private Cidade cidade;
	private Pessoa pessoa;
	private List<Pessoa> pessoas;

	private String cpfCnpj;
	private String nome;
	private String pesquisarCidade;

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public void setCidadeService(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}

	@PostConstruct
	public void init() {
		pessoas = new ArrayList<>();
		pessoa = new Pessoa();
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

	public void setPesquisarCidade(String pesquisarCidade) {
		this.pesquisarCidade = pesquisarCidade;
	}

	public String getPesquisarCidade() {
		return pesquisarCidade;
	}

	public String carregarPessoa() throws IOException {
		System.out.println(pessoa.getNomeFantasia());
		return "cadastro.xhtml";
	}

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) throws IOException {

		this.id = id;

		if (id != null) {
			pessoa = pessoaService.pesquisarPorId(id);
			System.out.println(pessoa.getNomeFantasia());
		} else {
			pessoa = new Pessoa();
			celular = new Telefone();
			comercial = new Telefone();
			residencial = new Telefone();
			endereco = new Endereco();
			cidade = cidadeService.pesquisarCidadePorNome(cidade.getNome());
		}
	}

	public void validarCidade() {

		cidade = cidadeService.pesquisarCidadePorNome(getCidade().getNome());

		if (cidade != null) {
			cidade.setEstado(cidade.getEstado());
		} else {
			setCidade(cidade);
		}
	}

	@Transactional
	public void salvar() {

		try {
			if (pessoa.getDataCadastro() == null) {
				pessoa.setDataCadastro(new Date());
			}
			
			validarCidade();
			pessoa.setEndereco(endereco);
			endereco.setCidade(cidade);
			pessoaService.save(pessoa);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
