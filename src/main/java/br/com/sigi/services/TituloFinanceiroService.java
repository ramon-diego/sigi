package br.com.sigi.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.sigi.model.TituloFinanceiro;
import br.com.sigi.repositories.TituloFinanceiroRepository;

@Service
public class TituloFinanceiroService implements Serializable {

	private static final long serialVersionUID = 3923094827351710450L;

	@Autowired
	TituloFinanceiroRepository tituloFinanceiroRepository;

	public void salvar(TituloFinanceiro tituloFinanceiro) {
		tituloFinanceiroRepository.save(tituloFinanceiro);
	}

	public List<TituloFinanceiro> pesquisarTitulo(String transacao, Long idTitulo, String situacaoTitulo,
			String nomePessoa, String cpfCnpj, String planoFinanceiro, String tipoDocumento, Date dataInicial,
			Date dataFinal) {

		Specification<TituloFinanceiro> specification = TituloFinanceiroSpecification.pesquisarTitulo(transacao,
				idTitulo, situacaoTitulo, nomePessoa, cpfCnpj, planoFinanceiro, tipoDocumento, dataInicial, dataFinal);
		return tituloFinanceiroRepository.findAll(specification);

	}

}
