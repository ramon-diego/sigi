package br.com.sigi.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import br.com.sigi.model.TituloFinanceiro;

public final class TituloFinanceiroSpecification {

	public static Specification<TituloFinanceiro> pesquisarTitulo(String transacao, Long idTitulo, String situacao,
			String nomePessoa, String cpfCnpj, String tipoDocumento, Date dataInicial, Date dataFinal) {
		return new Specification<TituloFinanceiro>() {

			@Override
			public Predicate toPredicate(Root<TituloFinanceiro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				final Collection<Predicate> predicates = new ArrayList<>();

				if (!StringUtils.isEmpty(transacao)) {
					final Predicate transacaoPredicate = cb.equal(root.get("transacao"), transacao);
					predicates.add(transacaoPredicate);
				}

				if (idTitulo != null) {
					final Predicate idTituloPredicate = cb.equal(root.get("id"), idTitulo);
					predicates.add(idTituloPredicate);
				}

				if (!StringUtils.isEmpty(situacao)) {
					final Predicate situacaoPredicate = cb.equal(root.get("situacaoTitulo"), situacao);
					predicates.add(situacaoPredicate);
				}

				if (!StringUtils.isEmpty(nomePessoa)) {
					final Predicate nomePessoaPredicate = cb.like(root.join("pessoa").get("nomeFantasia"),
							"%" + nomePessoa.trim() + "%");
					predicates.add(nomePessoaPredicate);
				}

				if (!StringUtils.isEmpty(cpfCnpj)) {
					final Predicate cpfCnpjPredicate = cb.like(root.join("pessoa").get("cpfCnpj"),
							"%" + cpfCnpj.trim() + "%");
					predicates.add(cpfCnpjPredicate);
				}

				if (!StringUtils.isEmpty(tipoDocumento)) {
					final Predicate tipoDocumentoPredicate = cb.equal(root.get("tipoDocumento"), tipoDocumento);
					predicates.add(tipoDocumentoPredicate);
				}

				if (dataInicial != null) {
				
					final Predicate dataVencimentoPredicate = cb.between(root.<Date>get("dataVencimento"), dataInicial, dataInicial);
					predicates.add(dataVencimentoPredicate);
				}

				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

}
