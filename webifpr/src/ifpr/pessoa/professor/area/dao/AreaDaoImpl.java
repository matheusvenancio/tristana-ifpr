package ifpr.pessoa.professor.area.dao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ifpr.dao.GenericDao;
import ifpr.pessoa.professor.area.Area;

@ManagedBean(name="areaDao")
@ApplicationScoped
public class AreaDaoImpl extends GenericDao<Area> implements AreaDao {

	private static final long serialVersionUID = 1L;

	public AreaDaoImpl() {
		super(Area.class);
	}

}
