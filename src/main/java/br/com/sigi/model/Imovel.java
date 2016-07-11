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
import javax.persistence.Table;

@Entity
@Table(name = "imovel")
public class Imovel implements Serializable {

	private static final long serialVersionUID = -8713206607694202240L;

	@Id
	@Column(name = "imovel_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Imovel() {

	}
	

	@Column
	@Enumerated(EnumType.STRING)
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

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((angariador == null) ? 0 : angariador.hashCode());
		result = prime * result + ((atributoImovel == null) ? 0 : atributoImovel.hashCode());
		result = prime * result + ((atualizadoEm == null) ? 0 : atualizadoEm.hashCode());
		result = prime * result + ((atualizadoPor == null) ? 0 : atualizadoPor.hashCode());
		result = prime * result + ((cadastradoPor == null) ? 0 : cadastradoPor.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((finalidade == null) ? 0 : finalidade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + ((proprietario == null) ? 0 : proprietario.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((taxaServico == null) ? 0 : taxaServico.hashCode());
		result = prime * result + ((tipoImovel == null) ? 0 : tipoImovel.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((valorAdministracao == null) ? 0 : valorAdministracao.hashCode());
		result = prime * result + ((valorCondominio == null) ? 0 : valorCondominio.hashCode());
		result = prime * result + ((valorIptu == null) ? 0 : valorIptu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (angariador == null) {
			if (other.angariador != null)
				return false;
		} else if (!angariador.equals(other.angariador))
			return false;
		if (atributoImovel == null) {
			if (other.atributoImovel != null)
				return false;
		} else if (!atributoImovel.equals(other.atributoImovel))
			return false;
		if (atualizadoEm == null) {
			if (other.atualizadoEm != null)
				return false;
		} else if (!atualizadoEm.equals(other.atualizadoEm))
			return false;
		if (atualizadoPor == null) {
			if (other.atualizadoPor != null)
				return false;
		} else if (!atualizadoPor.equals(other.atualizadoPor))
			return false;
		if (cadastradoPor == null) {
			if (other.cadastradoPor != null)
				return false;
		} else if (!cadastradoPor.equals(other.cadastradoPor))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (finalidade == null) {
			if (other.finalidade != null)
				return false;
		} else if (!finalidade.equals(other.finalidade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (proprietario == null) {
			if (other.proprietario != null)
				return false;
		} else if (!proprietario.equals(other.proprietario))
			return false;
		if (status != other.status)
			return false;
		if (taxaServico == null) {
			if (other.taxaServico != null)
				return false;
		} else if (!taxaServico.equals(other.taxaServico))
			return false;
		if (tipoImovel == null) {
			if (other.tipoImovel != null)
				return false;
		} else if (!tipoImovel.equals(other.tipoImovel))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (valorAdministracao == null) {
			if (other.valorAdministracao != null)
				return false;
		} else if (!valorAdministracao.equals(other.valorAdministracao))
			return false;
		if (valorCondominio == null) {
			if (other.valorCondominio != null)
				return false;
		} else if (!valorCondominio.equals(other.valorCondominio))
			return false;
		if (valorIptu == null) {
			if (other.valorIptu != null)
				return false;
		} else if (!valorIptu.equals(other.valorIptu))
			return false;
		return true;
	}
	
}
