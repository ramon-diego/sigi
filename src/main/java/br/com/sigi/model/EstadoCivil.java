package br.com.sigi.model;

public enum EstadoCivil {
	S("Solteiro"), C("Casado"), D("Divorciado");
	
	private EstadoCivil(String descricao) {
		this.descricao = descricao;
	}
	String descricao;
	
	@Override
	public String toString() {
		return  descricao;
	}
}
