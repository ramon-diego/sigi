package br.com.sigi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "titulo_financeiro")
public class TituloFinanceiro implements Serializable {

	private static final long serialVersionUID = -2199232518449759696L;

	public TituloFinanceiro() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "titulo_id")
	private Long id;

	@Column(length = 1, nullable = false)
	private String transacao;

	@OneToOne(orphanRemoval = true, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@Column(name = "data_emissao")
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;

	@Column(name = "data_vencimento")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	@Column(name = "data_registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRegistro;

	@Column(name = "data_baixa")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataBaixa;

	@Column(name = "valor_titulo")
	private BigDecimal valorTitulo;

	@Column(name = "valor_recebido")
	private BigDecimal valorRecebido;

	@Column(name = "juros")
	private BigDecimal juros;

	@Column(name = "desconto")
	private BigDecimal desconto;

	@Column(name = "saldo")
	private BigDecimal saldo;

	@Column(name = "tipo_documento")
	private String tipoDocumento;

	private String observacao;

	@Column(name = "numero_documento", length = 20, nullable = false)
	private String numeroDocumento;

	@Column(name = "nosso_numero", length = 15)
	private String nossoNumero;

	@Column(name = "status_titulo", length = 1, nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusTituloFinanceiro statusTitulo;

	@Column(name = "origem", length = 8, nullable = false)
	private String origemTitulo;

	@Column(name = "situacao", length = 7, nullable = false)
	private String situacaoTitulo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}

	public String getTransacao() {
		return transacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public BigDecimal getValorTitulo() {
		return valorTitulo;
	}

	public void setValorTitulo(BigDecimal valorTitulo) {
		this.valorTitulo = valorTitulo;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public Date getDataBaixa() {
		return dataBaixa;
	}

	public void setDataBaixa(Date dataBaixa) {
		this.dataBaixa = dataBaixa;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public StatusTituloFinanceiro getStatusTitulo() {
		return statusTitulo;
	}

	public void setStatusTitulo(StatusTituloFinanceiro statusTitulo) {
		this.statusTitulo = statusTitulo;
	}

	public void setOrigemTitulo(String origemTitulo) {
		this.origemTitulo = origemTitulo;
	}

	public String getOrigemTitulo() {
		return origemTitulo;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setSituacaoTitulo(String situacaoTitulo) {
		this.situacaoTitulo = situacaoTitulo;
	}

	public String getSituacaoTitulo() {
		return situacaoTitulo;
	}

}
