package br.com.sigi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Imovel implements Serializable {

	private static final long serialVersionUID = -8713206607694202240L;

	@Id
	@Column(name = "imovel_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Imovel() {

	}

	@Column
	private Status status;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "atualizado_em")
	private Date atualizadoEm;

	@Column(name = "atualizado_por")
	private Long atualizadoPor;

	@Column(name = "cadastrado_por")
	private Long cadastradoPor;

	@Column
	private String finalidade;

	@Column(name = "tipo_imovel")
	private String tipoImovel;

	@Column
	private BigDecimal valor;

	@Column(name = "valor_condominio")
	private BigDecimal valorCondominio;

	@Column(name = "valor_iptu")

	private BigDecimal valorIptu;

	@Column(name = "taxa_servico")
	private BigDecimal taxaServico;

	@Column(name = "valor_administracao")
	private BigDecimal valorAdministracao;

	@Column
	private String observacoes;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "proprietario_id")
	private Pessoa proprietario;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "angariador_id")
	private Pessoa angariador;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "atributo_id")
	private AtributoImovel atributoImovel;

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

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	public void setAngariador(Pessoa angariador) {
		this.angariador = angariador;
	}

	public Pessoa getAngariador() {
		return angariador;
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
