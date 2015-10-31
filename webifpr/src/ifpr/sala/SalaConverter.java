package ifpr.sala;

import ifpr.sala.dao.SalaDao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@ManagedBean(name = "salaConverter")
@ApplicationScoped
public class SalaConverter implements Converter {

	@ManagedProperty(value = "#{salaDao}")
	private SalaDao salaDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		
		if ( value != null && !value.isEmpty() && !value.equalsIgnoreCase("Selecione um") )
			
			try {
				return salaDao.pesquisarPorNome(value).get(0);
			} catch (IndexOutOfBoundsException e) {
				return null;
			}
			
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) throws ConverterException {
		
		if ( object instanceof Sala )
			return ((Sala)object).toString();
		
		return null;
	}

	public SalaDao getSalaDao()
	{
		return salaDao;
	}

	public void setSalaDao(SalaDao salaDao)
	{
		this.salaDao = salaDao;
	}
}