package ifpr.materia.dao;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ifpr.dao.GenericDao;
import ifpr.materia.Materia;


@ManagedBean(name="materiaDao")
@ApplicationScoped
public class MateriaDaoImpl extends GenericDao<Materia> implements MateriaDao {

	private static final long serialVersionUID = 1L;
	
	public MateriaDaoImpl() {
		super(Materia.class);
	}
	

}
