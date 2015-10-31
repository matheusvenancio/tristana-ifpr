package ifpr.pessoa.usuario.coordenador;


import ifpr.pessoa.usuario.coordenador.dao.CoordenadorDao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@ManagedBean(name = "coordenadorConverter")
@ApplicationScoped
public class CoordenadorConverter implements Converter {

	@ManagedProperty(value = "#{coordenadorDao}")
	private CoordenadorDao coordenadorDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		
		if ( value != null && !value.isEmpty() && !value.equalsIgnoreCase("Selecione um") )
			
			try {
				return coordenadorDao.pesquisarPorNome(value).get(0);
			} catch (IndexOutOfBoundsException e) {
				return null;
			}
			
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) throws ConverterException {
		
		if ( object instanceof Coordenador )
			return ((Coordenador)object).toString();
		
		return null;
	}

	public CoordenadorDao getCoordenadorDao()
	{
		return coordenadorDao;
	}

	public void setCoordenadorDao(CoordenadorDao coordenadorDao)
	{
		this.coordenadorDao = coordenadorDao;
	}
}