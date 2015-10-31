package ifpr.professorMateria.dao;

import ifpr.dao.GenericDao;
import ifpr.professorMateria.ProfessorMateria;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="professorMateriaDao")
@ApplicationScoped
public class ProfessorMateriaDaoImpl extends GenericDao<ProfessorMateria> implements ProfessorMateriaDao {

	private static final long serialVersionUID = 1L;

	public ProfessorMateriaDaoImpl() {
		super(ProfessorMateria.class);
	}

}
