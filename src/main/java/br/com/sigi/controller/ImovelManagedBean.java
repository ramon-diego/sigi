package br.com.sigi.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

import br.com.sigi.model.AtributoImovel;
import br.com.sigi.model.Cidade;
import br.com.sigi.model.Endereco;
import br.com.sigi.model.ExclusividadeImovel;
import br.com.sigi.model.Imovel;
import br.com.sigi.model.Pessoa;
import br.com.sigi.services.ExclusividadeImovelService;
import br.com.sigi.services.ImovelService;
import br.com.sigi.services.PessoaService;

@ManagedBean(name = "imovelBean")
@ViewScoped
public class ImovelManagedBean implements Serializable {

	private static final long serialVersionUID = 6729233648580056599L;
	private Imovel imovel;
	private Pessoa proprietario;
	private List<Imovel> imoveis;
	private List<Pessoa> proprietarios;
	private List<Pessoa> angariadores;
	private Pessoa angariador;
	private Endereco endereco;
	private Cidade cidade;
	private AtributoImovel atributoImovel;
	private ExclusividadeImovel exclusividadeImovel;

	// variaveis para pesquisa
	private Long id;
	private Integer qtdeDormitorio;
	private String tipoImovel;
	private String finalidade;
	private String ruaImovel;
	private String bairroImovel;
	private String cidadePesquisa;
	private Integer suite;
	private BigDecimal valorMinimo;
	private BigDecimal valorMaximo;
	private String nome;
	private String cpfCnpj;

	private Part arquivo;

	@PostConstruct
	public void init() {
		proprietario = new Pessoa();
		imovel = new Imovel();
		angariador = new Pessoa();
		endereco = new Endereco();
		atributoImovel = new AtributoImovel();
		cidade = new Cidade();
		proprietarios = new ArrayList<>();
		angariadores = new ArrayList<>();
		exclusividadeImovel = new ExclusividadeImovel();
	}

	public String upload;

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

	@ManagedProperty("#{imovelService}")
	private ImovelService imovelService;

	@ManagedProperty("#{pessoaService}")
	private PessoaService pessoaService;

	@ManagedProperty("#{exclusividadeImovelService}")
	private ExclusividadeImovelService exclusividadeImovelService;

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

	public void setExclusividadeImovel(ExclusividadeImovel exclusividadeImovel) {
		this.exclusividadeImovel = exclusividadeImovel;
	}

	public ExclusividadeImovel getExclusividadeImovel() {
		return exclusividadeImovel;
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

	public void setExclusividadeImovelService(ExclusividadeImovelService exclusividadeImovelService) {
		this.exclusividadeImovelService = exclusividadeImovelService;
	}

	public void setAtributoImovel(AtributoImovel atributoImovel) {
		this.atributoImovel = atributoImovel;
	}

	public List<Pessoa> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(List<Pessoa> proprietarios) {
		this.proprietarios = proprietarios;
	}

	public List<Pessoa> getAngariadores() {
		return angariadores;
	}

	public void setAngariadores(List<Pessoa> angariadores) {
		this.angariadores = angariadores;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

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

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void pesquisarProprietario() {
		proprietarios = pessoaService.pesquisarProprietario(getNome(), getCpfCnpj());
	}

	public void pesquisarAngariador() {
		angariadores = pessoaService.pesquisarAngariador(getNome());
	}

	public void registraAngariador(Pessoa angariador) {
		this.angariador = angariador;
	}

	public void pesquisarImoveis() {

		imoveis = imovelService.pesquisarImovel(getFinalidade(), getTipoImovel(), getId());
	}

	public void registraProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	public void teste() {
		imoveis = imovelService.PesquisarImoveis(getFinalidade(), getTipoImovel(), getId(), getRuaImovel(),
				getBairroImovel(), getCidadePesquisa(), getQtdeDormitorio(), getSuite(), getValorMinimo(),
				getValorMaximo());
	}

	public String getRuaImovel() {
		return ruaImovel;
	}

	public void setRuaImovel(String ruaImovel) {
		this.ruaImovel = ruaImovel;
	}

	public String getBairroImovel() {
		return bairroImovel;
	}

	public void setBairroImovel(String bairroImovel) {
		this.bairroImovel = bairroImovel;
	}

	public void setCidadePesquisa(String cidadePesquisa) {
		this.cidadePesquisa = cidadePesquisa;
	}

	public String getCidadePesquisa() {
		return cidadePesquisa;
	}

	public void setQtdeDormitorio(Integer qtdeDormitorio) {
		this.qtdeDormitorio = qtdeDormitorio;
	}

	public Integer getQtdeDormitorio() {
		return qtdeDormitorio;
	}

	public Integer getSuite() {
		return suite;
	}

	public void setSuite(Integer suite) {
		this.suite = suite;
	}

	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMaximo(BigDecimal valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public BigDecimal getValorMaximo() {
		return valorMaximo;
	}

	public void salvar() {
		try {
			imovel.setAtributoImovel(atributoImovel);
			imovel.setProprietario(proprietario);
			endereco.setCidade(cidade);
			imovel.setEndereco(endereco);
			exclusividadeImovel.setImovel(imovel);
			imovelService.salvar(imovel);
//			exclusividadeImovelService.salvar(exclusividadeImovel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
