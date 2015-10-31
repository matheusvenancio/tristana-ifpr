package ifpr.objeto.dao;

import ifpr.dao.GenericDao;
import ifpr.objeto.Objeto;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean(name="objetoPerdidoDao")
@ApplicationScoped
public class ObjetoDaoImpl extends GenericDao<Objeto> implements ObjetoDao {

	private static final long serialVersionUID = 1L;
	
	public ObjetoDaoImpl() {
		super(Objeto.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Objeto> pesquisarPorCategoria(String categoria) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select o from Objeto o where lower(o.categoria) in (select c from Categoria c where lower(c.nome) like concat(:curso,'%')) ");
		q.setParameter("categoria",categoria);
		q.setMaxResults(50);
		
		return q.getResultList();
	}
}
