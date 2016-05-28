package br.com.sigi.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "imoveisBean")
public class ImoveisManagedBean {

	public boolean numero = false;
	
	public void setNumero(boolean numero) {
		this.numero = numero;
	}
	public boolean getNumero() {
		return numero;
	}
}
