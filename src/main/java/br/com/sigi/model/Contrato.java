package br.com.sigi.model;

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

@Entity
public class Contrato {

	public Contrato() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 1)
	@Enumerated(EnumType.STRING)
	private TipoContrato tipoContrato;

	@Column(length = 10)
	private String numeroContrato;

	@Temporal(TemporalType.DATE)
	private Date dataRegistro;
	@Column(length = 10 )
	private String garantia;

	@Column(length = 5)
	private String baseReajuste;

	@Column(name = "data_inicio_contrato")
	@Temporal(TemporalType.DATE)
	private Date dataInicioContrato;

	@Column(name = "data_termino_contrato")
	@Temporal(TemporalType.DATE)
	private Date dataTerminoContrato;

	@Column(length = 8)
	private String prazo;

	@Column(length = 15, name = "numero_apolice_seguro")
	private String numeroApoliceSeguro;

	@Column(length = 8, name = "validade_apolice_seguro")
	private String validadeApoliceSeguro;

	@Column(length = 8, name = "data_inicio_apolice_seguro")
	@Temporal(TemporalType.DATE)
	private Date dataInicioApoliceSeguro;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "proprietario_id")
	private Pessoa proprietario;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fiador1")
	private Pessoa fiador1;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fiador2")
	private Pessoa fiador2;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "imovel_id")
	private Imovel imovel;


	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}	

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getBaseReajuste() {
		return baseReajuste;
	}

	public void setBaseReajuste(String baseReajuste) {
		this.baseReajuste = baseReajuste;
	}

	public Date getDataInicioContrato() {
		return dataInicioContrato;
	}

	public void setDataInicioContrato(Date dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}

	public Date getDataTerminoContrato() {
		return dataTerminoContrato;
	}

	public void setDataTerminoContrato(Date dataTerminoContrato) {
		this.dataTerminoContrato = dataTerminoContrato;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public void setNumeroApoliceSeguro(String numeroApoliceSeguro) {
		this.numeroApoliceSeguro = numeroApoliceSeguro;
	}

	public String getNumeroApoliceSeguro() {
		return numeroApoliceSeguro;
	}

	public void setDataInicioApoliceSeguro(Date dataInicioApoliceSeguro) {
		this.dataInicioApoliceSeguro = dataInicioApoliceSeguro;
	}

	public Date getDataInicioApoliceSeguro() {
		return dataInicioApoliceSeguro;
	}

	public void setValidadeApoliceSeguro(String validadeApoliceSeguro) {
		this.validadeApoliceSeguro = validadeApoliceSeguro;
	}

	public String getValidadeApoliceSeguro() {
		return validadeApoliceSeguro;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setFiador1(Pessoa fiador1) {
		this.fiador1 = fiador1;
	}

	public Pessoa getFiador1() {
		return fiador1;
	}

	public void setFiador2(Pessoa fiador2) {
		this.fiador2 = fiador2;
	}

	public Pessoa getFiador2() {
		return fiador2;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Imovel getImovel() {
		return imovel;
	}

}
