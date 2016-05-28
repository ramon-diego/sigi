package br.com.sigi.domain.imovel;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.sigi.domain.Status;

@Entity
public class Imovel {
	@Id
	private Long id;
	private Status status;
		
	private Date dataCadastro;
	private Date atualizadoEm;
	private Long atualizadoPor;
	private Long cadastradoPor;
	
	private BigDecimal valor;
	private BigDecimal valorCondominio;
	private BigDecimal taxaServico;
	private BigDecimal valorAdministracao;
	
	
	
	
	
	

}
