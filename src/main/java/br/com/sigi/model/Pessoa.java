package br.com.sigi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 7453129051870425636L;

	@Id
	@Column(name = "pessoa_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Pessoa() {

	}

	@Column(name = "nome_fantasia", length = 45)
	private String nomeFantasia;

	@Column(name = "data_cadastro")
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

	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy =
	// "pessoa")
	// private List<Telefone> telefones = new ArrayList<>();

	@Column
	private String email;

	@Column(length = 1)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
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
	@Column
	private Boolean isCorretor;
	@Column
	private Boolean isProprietario;
	@Column
	private Boolean isPrestador;
	@Column
	private Boolean isFiador;
	@Column
	private Boolean isLocatario;

	@OneToMany(targetEntity = Endereco.class, mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Endereco> enderecos = new HashSet<Endereco>();

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public void setId(Long id) {
		this.id = id;
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
	public Long getId() {
		return id;
	}

}