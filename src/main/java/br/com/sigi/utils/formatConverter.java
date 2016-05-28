package br.com.sigi.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("formatConverter")
public class formatConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String variavel) {
		if (variavel.trim().equals("")) {
			return null;
		} else {
			variavel = variavel.replace("-", "");
			variavel = variavel.replace(".", "");
			variavel = variavel.replace("/", "");
			variavel = variavel.replace("(", "");
			variavel = variavel.replace(")", "");
			variavel = variavel.trim().replaceAll(" ", "");
			return variavel;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
		return object.toString();
	}

}
