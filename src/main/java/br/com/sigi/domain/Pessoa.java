package br.com.sigi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.sigi.dao.EntidadeBase;

@Entity
@NamedQuery(name = Pessoa.BUSCAR_POR_VARIOS_ATRIBUTOS, query = "select p from Pessoa p "
		+ "where p.nomeFantasia like :nome or p.cpfCnpj like :cpfCnpj")

@Table(name = "PESSOA")
public class Pessoa implements Serializable, EntidadeBase {

	private static final long serialVersionUID = 1L;

	public static final String BUSCAR_POR_VARIOS_ATRIBUTOS = "Pessoa.BuscarPorVariosAtributos";
	public static final String BuscarPorNome = "Pessoa.BuscarPorVariosAtributos";

	@Id
	@Column(name = "id_pessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Pessoa() {

	}

	public Pessoa(Long id) {
		this.id = id;
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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pessoa", fetch = FetchType.EAGER)
	private List<Telefone> telefones = new ArrayList<>();

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

	@Column
	private String observacao;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pessoa", fetch = FetchType.EAGER)
	private List<Endereco> enderecos = new ArrayList<>();

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void adicionarEndereco(Endereco endereco) {
		enderecos.add(endereco);
		endereco.setPessoa(this);
	}

	public void removeEndereco(Endereco endereco) {
		enderecos.remove(endereco);
		endereco.setPessoa(null);
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
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

	public void adicionarTelefone(Telefone telefone) {
		telefones.add(telefone);
		telefone.setPessoa(this);
	}

	public void removerTelefone(Telefone telefone) {
		telefones.remove(telefone);
		telefone.setPessoa(null);
	}

	public List<Telefone> getTelefones() {
		return telefones;
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

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", tipoPessoa=" + tipoPessoa + ",nomeFantasia =" + nomeFantasia + ", razaoSocial="
				+ razaoSocial + ", cpfCpj=" + cpfCnpj + ", rgIe=" + rgIe + ", dataNascimento=" + dataNascimento
				+ ", sexo =" + sexo + ", estadoCivil = " + estadoCivil + ",email=" + email + "]";

	}

}