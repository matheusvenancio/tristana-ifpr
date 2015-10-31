package ifpr.horario.dao;


import java.util.List;

import ifpr.dao.GenericDao;
import ifpr.horario.Horario;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;


@ManagedBean(name="horarioDao")
@ApplicationScoped
public class HorarioDaoImpl extends GenericDao<Horario> implements HorarioDao {

	private static final long serialVersionUID = 1L;
	
	public HorarioDaoImpl() {
		super(Horario.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Horario> list(int first, int size) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT a from " + classe.getSimpleName() + " a order by a.aula.hora");
		query.setFirstResult(first);
		query.setMaxResults(size);
		return query.getResultList();
	}

}
