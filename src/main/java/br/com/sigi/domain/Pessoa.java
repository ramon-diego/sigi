package br.com.sigi.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pessoa() {

	}

	public Pessoa(String tipoPessoa, String razaoSocial, String cpfCnpj, String nomeFantasia, String rgIe,
			Date dataNascimento, String sexo, String naturalidade, String email) {
		
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cpfCnpj = cpfCnpj;
		this.rgIe = rgIe;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
				
	}

	@Id
	@Column(name = "id_pessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_fantasia")
	private String nomeFantasia;

	@Column(name = "razao_social")
	private String razaoSocial;

	@Column(length = 14, unique = true, name = "cpf_cnpj")
	private String cpfCnpj;

	@Column(name = "rg_ie")
	private String rgIe;

	@Column(name = "data_nascimento", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column
	private String naturalidade;

	@Column
	private String email;

	@Column(length = 1)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private TipoPessoa tipoPessoa;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable=false)
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, name = "estado_civil")
	private EstadoCivil estadoCivil;

	@Column
	@JoinColumn(nullable = false)
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", tipoPessoa=" + tipoPessoa + ",nomeFantasia =" + nomeFantasia + ", razaoSocial="
				+ razaoSocial + ", cpfCpj=" + cpfCnpj + ", rgIe=" + rgIe + ", dataNascimento=" + dataNascimento
				+ ", sexo =" + sexo + ", estadoCivil = " + estadoCivil + ",email=" + email + "]";

	}

}