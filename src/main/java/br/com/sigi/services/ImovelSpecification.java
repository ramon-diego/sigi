package br.com.sigi.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import br.com.sigi.model.Imovel;

public final class ImovelSpecification {

	public static Specification<Imovel> pesquisarImoveis(String finalidade, String tipoImovel, Long id, String rua,
			String bairro, String cidade, Integer dormitorio, Integer suite, BigDecimal valorMinimo,
			BigDecimal valorMaximo) {
		return new Specification<Imovel>() {

			@Override
			public Predicate toPredicate(Root<Imovel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				final Collection<Predicate> predicates = new ArrayList<>();

				if (!StringUtils.isEmpty(finalidade)) {
					final Predicate finalidadePredicate = cb.equal(root.get("finalidade"), finalidade);
					predicates.add(finalidadePredicate);
				}

				if (!StringUtils.isEmpty(tipoImovel)) {
					final Predicate tipoImovelPredicate = cb.equal(root.get("tipoImovel"), tipoImovel);
					predicates.add(tipoImovelPredicate);
				}

				if (!StringUtils.isEmpty(rua)) {
					final Predicate rualPredicate = cb.like(root.join("endereco").get("rua"), "%" + rua + "%");
					predicates.add(rualPredicate);
				}

				if (!StringUtils.isEmpty(bairro)) {
					final Predicate bairroPredicate = cb.like(root.join("endereco").get("bairro"), "%" + bairro + "%");
					predicates.add(bairroPredicate);
				}

				if (!StringUtils.isEmpty(cidade)) {
					final Predicate cidadePredicate = cb.like(root.join("endereco").join("cidade").get("nome"),
							"%" + cidade + "%");
					predicates.add(cidadePredicate);
				}

				if (dormitorio != null) {
					final Predicate dormitorioPredicate = cb.equal(root.join("atributoImovel").get("dormitorio"),
							dormitorio);
					predicates.add(dormitorioPredicate);
				}

				if (suite != null) {
					final Predicate suitePredicate = cb.equal(root.join("atributoImovel").get("suiteSimples"), suite);
					predicates.add(suitePredicate);
				}

				if (valorMinimo != null) {
					final Predicate valorMinimoPredicate = cb.and(cb.ge(root.get("valor"), valorMinimo));
					predicates.add(valorMinimoPredicate);
				}

				if (valorMaximo != null) {
					final Predicate valorMaximoPredicate = cb.and(cb.le(root.get("valor"), valorMaximo));
					predicates.add(valorMaximoPredicate);
				}

				if (id != null) {
					final Predicate idPredicate = cb.equal(root.get("id"), id);
					predicates.add(idPredicate);
				}

				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

}
