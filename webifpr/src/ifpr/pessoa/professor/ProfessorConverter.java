package ifpr.pessoa.professor;

import ifpr.pessoa.professor.dao.ProfessorDao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@ManagedBean(name = "professorConverter")
@ApplicationScoped
public class ProfessorConverter implements Converter {

	@ManagedProperty(value = "#{professorDao}")
	private ProfessorDao professorDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		
		if ( value != null && !value.isEmpty() && !value.equalsIgnoreCase("Selecione um") )
			
			try {
				return professorDao.pesquisarPorNome(value).get(0);
			} catch (IndexOutOfBoundsException e) {
				return null;
			}
			
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) throws ConverterException {
		
		if ( object instanceof Professor )
			return ((Professor)object).toString();
		
		return null;
	}

	public ProfessorDao getProfessorDao()
	{
		return professorDao;
	}

	public void setProfessorDao(ProfessorDao professorDao)
	{
		this.professorDao = professorDao;
	}
}