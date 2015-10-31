package ifpr.curso;

import ifpr.curso.dao.CursoDao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@ManagedBean(name = "cursoConverter")
@ApplicationScoped
public class CursoConverter implements Converter {

	@ManagedProperty(value = "#{cursoDao}")
	private CursoDao cursoDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		
		if ( value != null && !value.isEmpty() && !value.equalsIgnoreCase("Selecione um") )
			
			try {
				return cursoDao.pesquisarPorNome(value).get(0);
			} catch (IndexOutOfBoundsException e) {
				return null;
			}
			
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) throws ConverterException {
		
		if ( object instanceof Curso )
			return ((Curso)object).toString();
		
		return null;
	}

	public CursoDao getCursoDao()
	{
		return cursoDao;
	}

	public void setCursoDao(CursoDao cursoDao)
	{
		this.cursoDao = cursoDao;
	}
}