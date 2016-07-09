package br.com.sigi.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import br.com.sigi.model.Imovel;
import br.com.sigi.repositories.ImovelRepository;

@Service
public class ImovelService implements Serializable {

	private static final long serialVersionUID = -8300788431671812846L;

	@Autowired
	ImovelRepository imovelRepository;

	public void salvar(Imovel imovel) {
		imovelRepository.save(imovel);
	}

	public List<Imovel> pesquisarImovel(String finalidade, String tipoImovel, Long id) {

		return imovelRepository.pesquisarImovel(finalidade, tipoImovel, id);
	}

	public List<Imovel> PesquisarImoveis(String finalidade, String tipoImovel, Long id, String rua, String bairro,
			String cidade, Integer quarto, Integer suite, BigDecimal valorMinimo, BigDecimal valorMaximo) {

		Specification<Imovel> specification = ImovelSpecification.pesquisarImoveis(finalidade, tipoImovel, id, rua,
				bairro, cidade, quarto, suite, valorMinimo, valorMaximo);
		return imovelRepository.findAll(specification);

	}
}
