package br.com.sigi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.sigi.model.Pessoa;
import br.com.sigi.model.PlanoFinanceiro;
import br.com.sigi.model.StatusTituloFinanceiro;
import br.com.sigi.model.TituloFinanceiro;
import br.com.sigi.services.PessoaService;
import br.com.sigi.services.PlanoFinanceiroService;
import br.com.sigi.services.TituloFinanceiroService;

@ViewScoped
@ManagedBean(name = "tituloFinanceiroBean")
public class TituloFinanceiroManagedBean implements Serializable {

	private static final long serialVersionUID = -6604656323679697401L;

	private TituloFinanceiro tituloFinanceiro;

	private List<TituloFinanceiro> titulosFinanceiros;

	private Pessoa pessoaTitulo;

	private List<Pessoa> pessoas;

	private List<PlanoFinanceiro> planosFinanceiros;

	private PlanoFinanceiro planoFinanceiroSelecionado;

	// variáveis para pesquisa
	private String nomeInput;
	private String cpfCnpjInput;
	private String transacao;
	private Long idTitulo;
	private String situacaoTitulo;
	private String nomePessoa;
	private String cpfCnpj;
	private String tipoDocumento;
	private Date dataVencimento;
	private Date dataFinal;
	private String planoFinanceiro;

	@ManagedProperty("#{tituloFinanceiroService}")
	private TituloFinanceiroService tituloFinanceiroService;

	@ManagedProperty("#{pessoaService}")
	private PessoaService pessoaService;

	@ManagedProperty("#{planoFinanceiroService}")
	private PlanoFinanceiroService planoFinanceiroService;

	@PostConstruct
	public void init() {
		pessoaTitulo = new Pessoa();
		tituloFinanceiro = new TituloFinanceiro();
		pessoas = new ArrayList<>();
		planoFinanceiroSelecionado = new PlanoFinanceiro();
		titulosFinanceiros = new ArrayList<>();
		planosFinanceiros = new ArrayList<>();
		getPlanosFinanceiros();
	}

	public void setPlanoFinanceiroService(PlanoFinanceiroService planoFinanceiroService) {
		this.planoFinanceiroService = planoFinanceiroService;
	}

	public void setTituloFinanceiro(TituloFinanceiro tituloFinanceiro) {
		this.tituloFinanceiro = tituloFinanceiro;
	}

	public TituloFinanceiro getTituloFinanceiro() {
		return tituloFinanceiro;
	}

	public void setPlanosFinanceiros(List<PlanoFinanceiro> planosFinanceiros) {
		this.planosFinanceiros = planosFinanceiros;
	}

	public List<PlanoFinanceiro> getPlanosFinanceiros() {
		return planosFinanceiros = planoFinanceiroService.findAll();
	}

	public Pessoa getPessoaTitulo() {
		return pessoaTitulo;
	}

	public void setPessoaTitulo(Pessoa pessoaTitulo) {
		this.pessoaTitulo = pessoaTitulo;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public void setPlanoFinanceiroSelecionado(PlanoFinanceiro planoFinanceiroSelecionado) {
		this.planoFinanceiroSelecionado = planoFinanceiroSelecionado;
	}

	public PlanoFinanceiro getPlanoFinanceiroSelecionado() {
		return planoFinanceiroSelecionado;
	}

	public void setTitulosFinanceiros(List<TituloFinanceiro> titulosFinanceiros) {
		this.titulosFinanceiros = titulosFinanceiros;
	}

	public List<TituloFinanceiro> getTitulosFinanceiros() {
		return titulosFinanceiros;
	}

	public List<PlanoFinanceiro> findAll() {
		return planosFinanceiros = planoFinanceiroService.findAll();
	}

	public void setTituloFinanceiroService(TituloFinanceiroService tituloFinanceiroService) {
		this.tituloFinanceiroService = tituloFinanceiroService;
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public void registrarPessoaTitulo(Pessoa pessoa) {
		this.pessoaTitulo = pessoa;
	}

	public void pesquisarPessoas() {
		pessoas = pessoaService.pesquisarPessoaTitulo(getNomeInput(), getCpfCnpjInput());
	}

	public void pesquisarTitulo() {
		titulosFinanceiros = tituloFinanceiroService.pesquisarTitulo(getTransacao(), getIdTitulo(), getSituacaoTitulo(),
				getNomePessoa(), getCpfCnpj(), getPlanoFinanceiro(), getTipoDocumento(), getDataVencimento(), getDataFinal());
	}

	public void validarTitulo() {
		if (tituloFinanceiro.getDataRegistro() == null) {
			tituloFinanceiro.setDataRegistro(new Date());
		}

		if (tituloFinanceiro.getOrigemTitulo() == null) {
			tituloFinanceiro.setOrigemTitulo("Manual");
		}
		if (tituloFinanceiro.getSituacaoTitulo() == null) {
			tituloFinanceiro.setSituacaoTitulo("Aberto");
		}

		if (tituloFinanceiro.getStatusTitulo() == null) {
			tituloFinanceiro.setStatusTitulo(StatusTituloFinanceiro.N);
		}

	}

	public void salvar() {
		validarTitulo();
		tituloFinanceiro.setPessoa(pessoaTitulo);
		tituloFinanceiro.setPlanoFinanceiro(planoFinanceiroSelecionado);
		tituloFinanceiroService.salvar(tituloFinanceiro);
	}

	public String getCpfCnpjInput() {
		return cpfCnpjInput;
	}

	public void setCpfCnpjInput(String cpfCnpjInput) {
		this.cpfCnpjInput = cpfCnpjInput;
	}

	public String getNomeInput() {
		return nomeInput;
	}

	public void setNomeInput(String nomeInput) {
		this.nomeInput = nomeInput;
	}

	public void setIdTitulo(Long idTitulo) {
		this.idTitulo = idTitulo;
	}

	public Long getIdTitulo() {
		return idTitulo;
	}

	public void setSituacaoTitulo(String situacaoTitulo) {
		this.situacaoTitulo = situacaoTitulo;
	}

	public String getSituacaoTitulo() {
		return situacaoTitulo;
	}

	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}

	public String getTransacao() {
		return transacao;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setPlanoFinanceiro(String planoFinanceiro) {
		this.planoFinanceiro = planoFinanceiro;
	}

	public String getPlanoFinanceiro() {
		return planoFinanceiro;
	}

}
