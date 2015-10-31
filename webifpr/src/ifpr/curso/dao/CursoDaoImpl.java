package ifpr.curso.dao;

import java.util.List;

import ifpr.curso.Curso;
import ifpr.dao.GenericDao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean(name="cursoDao")
@ApplicationScoped
public class CursoDaoImpl extends GenericDao<Curso> implements CursoDao {

	private static final long serialVersionUID = 1L;
	
	public CursoDaoImpl() {
		super(Curso.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> pesquisarPorNome(String nome) {
			
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select u from Curso u where lower(u.nome) like concat(:nome, '%')");
		q.setParameter("nome", nome);
		q.setMaxResults(50);
		
		return q.getResultList();
	}
	
	@Override
	public Curso pesquisarPorCoordenador(Integer id) {
			
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select u from Curso u where u.id in ( select c.curso.id from Coordenador c where c.id = :id)");
		q.setParameter("id", id);
				
		return (Curso) q.getSingleResult();
	}
	
	
}
