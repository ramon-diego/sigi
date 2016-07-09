package br.com.sigi.model;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 7453129051870425636L;

	@Id
	@Column(name = "pessoa_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Pessoa() {

	}

	@Column(name = "nome_fantasia", length = 45, nullable=false, unique=true)
	private String nomeFantasia;

	@Column(name = "data_cadastro", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	@Column(name = "razao_social")
	private String razaoSocial;

	@Column(length = 14, unique = false, name = "cpf_cnpj", nullable = false)
	private String cpfCnpj;

	@Column(name = "rg_ie")
	private String rgIe;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column
	private String naturalidade;

	@Column(length = 10)
	private String creci;

	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy =
	// "pessoa")
	// private List<Telefone> telefones = new ArrayList<>();

	@Column
	private String email;

	@Column(length = 1)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false, name="tipo_pessoa")
	private TipoPessoa tipoPessoa;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, name = "estado_civil")
	private EstadoCivil estadoCivil;

	@Column(length = 11, name = "cpf_conjuge")
	private String cpfConjuge;

	@Column(length = 45, name = "nome_conjuge")
	private String nomeConjuge;

	@Column
	private String observacao;
	
	@Column(name ="is_corretor")
	private Boolean isCorretor;
	
	@Column(name ="is_proprietario")
	private Boolean isProprietario;
	
	@Column(name ="is_prestador")
	private Boolean isPrestador;
	
	@Column(name ="is_fiador")
	private Boolean isFiador;
	
	@Column(name ="is_locatario")
	private Boolean isLocatario;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getCpfConjuge() {
		return cpfConjuge;
	}

	public void setCpfConjuge(String cpfConjuge) {
		this.cpfConjuge = cpfConjuge;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRgIe() {
		return rgIe;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// public void adicionarTelefone(Telefone telefone) {
	// telefones.add(telefone);
	// telefone.setPessoa(this);
	// }
	//
	// public void removerTelefone(Telefone telefone) {
	// telefones.remove(telefone);
	// telefone.setPessoa(null);
	// }
	//
	// public List<Telefone> getTelefones() {
	// return telefones;
	// }

	public void setRgIe(String rgIe) {
		this.rgIe = rgIe;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getIsCorretor() {
		return isCorretor;
	}

	public void setIsCorretor(Boolean isCorretor) {
		this.isCorretor = isCorretor;
	}

	public Boolean getIsProprietario() {
		return isProprietario;
	}

	public void setIsProprietario(Boolean isProprietario) {
		this.isProprietario = isProprietario;
	}

	public Boolean getIsPrestador() {
		return isPrestador;
	}

	public void setIsPrestador(Boolean isPrestador) {
		this.isPrestador = isPrestador;
	}

	public Boolean getIsFiador() {
		return isFiador;
	}

	public void setIsFiador(Boolean isFiador) {
		this.isFiador = isFiador;
	}

	public Boolean getIsLocatario() {
		return isLocatario;
	}

	public void setIsLocatario(Boolean isLocatario) {
		this.isLocatario = isLocatario;
	}

	public void setCreci(String creci) {
		this.creci = creci;
	}

	public String getCreci() {
		return creci;
	}

	// @Override
	// public String toString() {
	//
	// return "Pessoa [id=" + id + ", tipoPessoa=" + tipoPessoa + ",
	// nomeFantasia=" + nomeFantasia + ", razaoSocial="
	// + razaoSocial + ", cpfCpj=" + cpfCnpj + ", rgIe=" + rgIe + ",
	// dataNascimento=" + dataNascimento
	// + ",naturalidade=" + naturalidade + ",observacao =" + observacao + ",
	// sexo =" + sexo
	// + ", estadoCivil =" + estadoCivil + ",email=" + email + ",nomeConjuge ="
	// + nomeConjuge + ",cpfConjuge=" + cpfConjuge + "]";
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
		result = prime * result + ((cpfConjuge == null) ? 0 : cpfConjuge.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isCorretor == null) ? 0 : isCorretor.hashCode());
		result = prime * result + ((isFiador == null) ? 0 : isFiador.hashCode());
		result = prime * result + ((isLocatario == null) ? 0 : isLocatario.hashCode());
		result = prime * result + ((isPrestador == null) ? 0 : isPrestador.hashCode());
		result = prime * result + ((isProprietario == null) ? 0 : isProprietario.hashCode());
		result = prime * result + ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nomeConjuge == null) ? 0 : nomeConjuge.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result + ((rgIe == null) ? 0 : rgIe.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoPessoa == null) ? 0 : tipoPessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cpfCnpj == null) {
			if (other.cpfCnpj != null)
				return false;
		} else if (!cpfCnpj.equals(other.cpfCnpj))
			return false;
		if (cpfConjuge == null) {
			if (other.cpfConjuge != null)
				return false;
		} else if (!cpfConjuge.equals(other.cpfConjuge))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estadoCivil != other.estadoCivil)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isCorretor == null) {
			if (other.isCorretor != null)
				return false;
		} else if (!isCorretor.equals(other.isCorretor))
			return false;
		if (isFiador == null) {
			if (other.isFiador != null)
				return false;
		} else if (!isFiador.equals(other.isFiador))
			return false;
		if (isLocatario == null) {
			if (other.isLocatario != null)
				return false;
		} else if (!isLocatario.equals(other.isLocatario))
			return false;
		if (isPrestador == null) {
			if (other.isPrestador != null)
				return false;
		} else if (!isPrestador.equals(other.isPrestador))
			return false;
		if (isProprietario == null) {
			if (other.isProprietario != null)
				return false;
		} else if (!isProprietario.equals(other.isProprietario))
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nomeConjuge == null) {
			if (other.nomeConjuge != null)
				return false;
		} else if (!nomeConjuge.equals(other.nomeConjuge))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (rgIe == null) {
			if (other.rgIe != null)
				return false;
		} else if (!rgIe.equals(other.rgIe))
			return false;
		if (sexo != other.sexo)
			return false;
		if (status != other.status)
			return false;
		if (tipoPessoa != other.tipoPessoa)
			return false;
		return true;
	}
}