package ifpr.turma;

import ifpr.turma.dao.TurmaDao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@ManagedBean(name = "turmaConverter")
@ApplicationScoped
public class TurmaConverter implements Converter {

	@ManagedProperty(value = "#{turmaDao}")
	private TurmaDao turmaDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		
		if ( value != null && !value.isEmpty() && !value.equalsIgnoreCase("Selecione um") )
			
			try {
				return turmaDao.pesquisarPorNome(value).get(0);
			} catch (IndexOutOfBoundsException e) {
				return null;
			}
			
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) throws ConverterException {
		
		if ( object instanceof Turma )
			return ((Turma)object).toString();
		
		return null;
	}

	public TurmaDao getTurmaDao()
	{
		return turmaDao;
	}

	public void setTurmaDao(TurmaDao turmaDao)
	{	
		this.turmaDao = turmaDao;
	}
}