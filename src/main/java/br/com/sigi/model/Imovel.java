package br.com.sigi.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;


public class Imovel {
	@Id
	private Long id;
	private Status status;

	@Column(name = "data_cadastro")
	private Date dataCadastro;
	@Column(name = "atualizado_em")
	private Date atualizadoEm;
	@Column(name = "atualizado_por")
	private Long atualizadoPor;
	@Column(name = "cadastrado_por")
	private Long cadastradoPor;

	private String finalidade;
	@Column(name = "tipo_imovel")
	private String tipoImovel;

	private BigDecimal valor;
	@Column(name = "valor_condominio")
	private BigDecimal valorCondominio;
	@Column(name = "valor_iptu")
	private BigDecimal valorIptu;
	@Column(name = "taxa_servico")
	private BigDecimal taxaServico;
	@Column(name = "valor_administracao")
	private BigDecimal valorAdministracao;
	
	private Pessoa proprietario;
	private Pessoa corretor;
	

	
	private Endereco endereco;
	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(Date atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public Long getAtualizadoPor() {
		return atualizadoPor;
	}

	public void setAtualizadoPor(Long atualizadoPor) {
		this.atualizadoPor = atualizadoPor;
	}

	public Long getCadastradoPor() {
		return cadastradoPor;
	}

	public void setCadastradoPor(Long cadastradoPor) {
		this.cadastradoPor = cadastradoPor;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorCondominio() {
		return valorCondominio;
	}

	public void setValorCondominio(BigDecimal valorCondominio) {
		this.valorCondominio = valorCondominio;
	}

	public BigDecimal getValorIptu() {
		return valorIptu;
	}

	public void setValorIptu(BigDecimal valorIptu) {
		this.valorIptu = valorIptu;
	}

	public BigDecimal getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(BigDecimal taxaServico) {
		this.taxaServico = taxaServico;
	}

	public BigDecimal getValorAdministracao() {
		return valorAdministracao;
	}

	public void setValorAdministracao(BigDecimal valorAdministracao) {
		this.valorAdministracao = valorAdministracao;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	public Pessoa getCorretor() {
		return corretor;
	}

	public void setCorretor(Pessoa corretor) {
		this.corretor = corretor;
	}



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	
	
}
