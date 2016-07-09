package br.com.sigi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "atributo_imovel")
public class AtributoImovel implements Serializable{

	private static final long serialVersionUID = -6215917883774800615L;

	@Id
	@Column(name = "atributo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer dormitorio;
	private Integer sala;
	private Integer cozinha;
	
	@Column(name = "suite_simples")
	private Integer suiteSimples;
	
	@Column(name = "suite_master")
	private Integer suiteMaster;
	
	@Column(name = "bwc_social")
	private Integer bwcSocial;
	
	@Column(name = "bwc_suite")
	private Integer bwcSuite;
	
	@Column(name = "area_de_servico")
	private Integer areaDeServico;
	
	@Column(name = "vaga_garagem")
	private Integer vagaGaragem;
	
	private Integer elevador;

	private boolean monitoramento;
	
	private boolean portaria;
	
	@Column(name = "portao_eletronico")
	private boolean portaoEletronico;
	
	private boolean churrasqueira;
	
	@Column(name = "espaco_gourmet")
	private boolean espacoGourmet;
	
	@Column(name = "piscina_adulto")
	private boolean piscinaAdulto;
	
	@Column(name = "piscina_infatil")
	private boolean piscinaInfantil;
	
	private boolean playground;
	
	@Column(name = "quadra_poliesportiva")
	private boolean quadraPoliesportiva;
	
	@Column(name = "salao_festa")
	private boolean salaoDeFesta;

	public AtributoImovel() {

	}

	public Integer getDormitorio() {
		return dormitorio;
	}

	public void setDormitorio(Integer dormitorio) {
		this.dormitorio = dormitorio;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public Integer getCozinha() {
		return cozinha;
	}

	public void setCozinha(Integer cozinha) {
		this.cozinha = cozinha;
	}

	public Integer getSuiteSimples() {
		return suiteSimples;
	}

	public void setSuiteSimples(Integer suiteSimples) {
		this.suiteSimples = suiteSimples;
	}

	public Integer getSuiteMaster() {
		return suiteMaster;
	}

	public void setSuiteMaster(Integer suiteMaster) {
		this.suiteMaster = suiteMaster;
	}

	public Integer getBwcSocial() {
		return bwcSocial;
	}

	public void setBwcSocial(Integer bwcSocial) {
		this.bwcSocial = bwcSocial;
	}

	public Integer getBwcSuite() {
		return bwcSuite;
	}

	public void setBwcSuite(Integer bwcSuite) {
		this.bwcSuite = bwcSuite;
	}

	public Integer getAreaDeServico() {
		return areaDeServico;
	}

	public void setAreaDeServico(Integer areaDeServico) {
		this.areaDeServico = areaDeServico;
	}

	public Integer getVagaGaragem() {
		return vagaGaragem;
	}

	public void setVagaGaragem(Integer vagaGaragem) {
		this.vagaGaragem = vagaGaragem;
	}

	public Integer getElevador() {
		return elevador;
	}

	public void setElevador(Integer elevador) {
		this.elevador = elevador;
	}

	public boolean isMonitoramento() {
		return monitoramento;
	}

	public void setMonitoramento(boolean monitoramento) {
		this.monitoramento = monitoramento;
	}

	public boolean isPortaria() {
		return portaria;
	}

	public void setPortaria(boolean portaria) {
		this.portaria = portaria;
	}

	public boolean isPortaoEletronico() {
		return portaoEletronico;
	}

	public void setPortaoEletronico(boolean portaoEletronico) {
		this.portaoEletronico = portaoEletronico;
	}

	public boolean isChurrasqueira() {
		return churrasqueira;
	}

	public void setChurrasqueira(boolean churrasqueira) {
		this.churrasqueira = churrasqueira;
	}

	public boolean isEspacoGourmet() {
		return espacoGourmet;
	}

	public void setEspacoGourmet(boolean espacoGourmet) {
		this.espacoGourmet = espacoGourmet;
	}

	public boolean isPiscinaAdulto() {
		return piscinaAdulto;
	}

	public void setPiscinaAdulto(boolean piscinaAdulto) {
		this.piscinaAdulto = piscinaAdulto;
	}

	public boolean isPiscinaInfantil() {
		return piscinaInfantil;
	}

	public void setPiscinaInfantil(boolean piscinaInfantil) {
		this.piscinaInfantil = piscinaInfantil;
	}

	public boolean isPlayground() {
		return playground;
	}

	public void setPlayground(boolean playground) {
		this.playground = playground;
	}

	public boolean isQuadraPoliesportiva() {
		return quadraPoliesportiva;
	}

	public void setQuadraPoliesportiva(boolean quadraPoliesportiva) {
		this.quadraPoliesportiva = quadraPoliesportiva;
	}

	public boolean isSalaoDeFesta() {
		return salaoDeFesta;
	}

	public void setSalaoDeFesta(boolean salaoDeFesta) {
		this.salaoDeFesta = salaoDeFesta;
	}
}
