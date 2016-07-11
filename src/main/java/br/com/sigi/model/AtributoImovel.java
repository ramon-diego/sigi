package br.com.sigi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "atributo_imovel")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaDeServico == null) ? 0 : areaDeServico.hashCode());
		result = prime * result + ((bwcSocial == null) ? 0 : bwcSocial.hashCode());
		result = prime * result + ((bwcSuite == null) ? 0 : bwcSuite.hashCode());
		result = prime * result + (churrasqueira ? 1231 : 1237);
		result = prime * result + ((cozinha == null) ? 0 : cozinha.hashCode());
		result = prime * result + ((dormitorio == null) ? 0 : dormitorio.hashCode());
		result = prime * result + ((elevador == null) ? 0 : elevador.hashCode());
		result = prime * result + (espacoGourmet ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (monitoramento ? 1231 : 1237);
		result = prime * result + (piscinaAdulto ? 1231 : 1237);
		result = prime * result + (piscinaInfantil ? 1231 : 1237);
		result = prime * result + (playground ? 1231 : 1237);
		result = prime * result + (portaoEletronico ? 1231 : 1237);
		result = prime * result + (portaria ? 1231 : 1237);
		result = prime * result + (quadraPoliesportiva ? 1231 : 1237);
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + (salaoDeFesta ? 1231 : 1237);
		result = prime * result + ((suiteMaster == null) ? 0 : suiteMaster.hashCode());
		result = prime * result + ((suiteSimples == null) ? 0 : suiteSimples.hashCode());
		result = prime * result + ((vagaGaragem == null) ? 0 : vagaGaragem.hashCode());
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
		AtributoImovel other = (AtributoImovel) obj;
		if (areaDeServico == null) {
			if (other.areaDeServico != null)
				return false;
		} else if (!areaDeServico.equals(other.areaDeServico))
			return false;
		if (bwcSocial == null) {
			if (other.bwcSocial != null)
				return false;
		} else if (!bwcSocial.equals(other.bwcSocial))
			return false;
		if (bwcSuite == null) {
			if (other.bwcSuite != null)
				return false;
		} else if (!bwcSuite.equals(other.bwcSuite))
			return false;
		if (churrasqueira != other.churrasqueira)
			return false;
		if (cozinha == null) {
			if (other.cozinha != null)
				return false;
		} else if (!cozinha.equals(other.cozinha))
			return false;
		if (dormitorio == null) {
			if (other.dormitorio != null)
				return false;
		} else if (!dormitorio.equals(other.dormitorio))
			return false;
		if (elevador == null) {
			if (other.elevador != null)
				return false;
		} else if (!elevador.equals(other.elevador))
			return false;
		if (espacoGourmet != other.espacoGourmet)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (monitoramento != other.monitoramento)
			return false;
		if (piscinaAdulto != other.piscinaAdulto)
			return false;
		if (piscinaInfantil != other.piscinaInfantil)
			return false;
		if (playground != other.playground)
			return false;
		if (portaoEletronico != other.portaoEletronico)
			return false;
		if (portaria != other.portaria)
			return false;
		if (quadraPoliesportiva != other.quadraPoliesportiva)
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		if (salaoDeFesta != other.salaoDeFesta)
			return false;
		if (suiteMaster == null) {
			if (other.suiteMaster != null)
				return false;
		} else if (!suiteMaster.equals(other.suiteMaster))
			return false;
		if (suiteSimples == null) {
			if (other.suiteSimples != null)
				return false;
		} else if (!suiteSimples.equals(other.suiteSimples))
			return false;
		if (vagaGaragem == null) {
			if (other.vagaGaragem != null)
				return false;
		} else if (!vagaGaragem.equals(other.vagaGaragem))
			return false;
		return true;
	}
	 
	
}
