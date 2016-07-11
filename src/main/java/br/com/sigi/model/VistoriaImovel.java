package br.com.sigi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vistoria_imovel")
public class VistoriaImovel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "imovel_id")
	private Imovel imovel;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "inquilino_id", nullable = false)
	private Pessoa inquilino;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_vistoria", nullable = false)
	private Date dataVistoria;

	@Column(name = "data_registro")
	@Temporal(TemporalType.DATE)
	private Date dataRegistro;

	@Column(name = "tipo_vistoria", length = 8, nullable = false)
	private String tipoVistoria;

	private String observacao;

	@Column(nullable = false)
	private String status;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "vistoriador_id", nullable = false)
	private Pessoa vistoriador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Pessoa getInquilino() {
		return inquilino;
	}

	public void setInquilino(Pessoa inquilino) {
		this.inquilino = inquilino;
	}

	public Date getDataVistoria() {
		return dataVistoria;
	}

	public void setDataVistoria(Date dataVistoria) {
		this.dataVistoria = dataVistoria;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getTipoVistoria() {
		return tipoVistoria;
	}

	public void setTipoVistoria(String tipoVistoria) {
		this.tipoVistoria = tipoVistoria;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Pessoa getVistoriador() {
		return vistoriador;
	}

	public void setVistoriador(Pessoa vistoriador) {
		this.vistoriador = vistoriador;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public VistoriaImovel() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRegistro == null) ? 0 : dataRegistro.hashCode());
		result = prime * result + ((dataVistoria == null) ? 0 : dataVistoria.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imovel == null) ? 0 : imovel.hashCode());
		result = prime * result + ((inquilino == null) ? 0 : inquilino.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoVistoria == null) ? 0 : tipoVistoria.hashCode());
		result = prime * result + ((vistoriador == null) ? 0 : vistoriador.hashCode());
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
		VistoriaImovel other = (VistoriaImovel) obj;
		if (dataRegistro == null) {
			if (other.dataRegistro != null)
				return false;
		} else if (!dataRegistro.equals(other.dataRegistro))
			return false;
		if (dataVistoria == null) {
			if (other.dataVistoria != null)
				return false;
		} else if (!dataVistoria.equals(other.dataVistoria))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imovel == null) {
			if (other.imovel != null)
				return false;
		} else if (!imovel.equals(other.imovel))
			return false;
		if (inquilino == null) {
			if (other.inquilino != null)
				return false;
		} else if (!inquilino.equals(other.inquilino))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoVistoria == null) {
			if (other.tipoVistoria != null)
				return false;
		} else if (!tipoVistoria.equals(other.tipoVistoria))
			return false;
		if (vistoriador == null) {
			if (other.vistoriador != null)
				return false;
		} else if (!vistoriador.equals(other.vistoriador))
			return false;
		return true;
	}

}
