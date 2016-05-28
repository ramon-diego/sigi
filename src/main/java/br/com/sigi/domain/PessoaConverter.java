package br.com.sigi.domain;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sigi.utils.ConexaoDB;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter, Serializable {


	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if (string == null || string.isEmpty()) {
			return null;
		}
		return ConexaoDB.getEntityManager().find(Pessoa.class, Long.valueOf(string));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Pessoa pessoa = (Pessoa) object;
		if (pessoa == null || pessoa.getId() == null) {
			return null;
		}
		return String.valueOf(pessoa.getId());
	}

}
