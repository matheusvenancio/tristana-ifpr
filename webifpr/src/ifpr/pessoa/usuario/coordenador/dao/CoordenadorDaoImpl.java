package ifpr.pessoa.usuario.coordenador.dao;

import java.util.List;

import ifpr.dao.GenericDao;
import ifpr.pessoa.usuario.coordenador.Coordenador;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean(name="coordenadorDao")
@ApplicationScoped
public class CoordenadorDaoImpl extends GenericDao<Coordenador> implements CoordenadorDao {

	private static final long serialVersionUID = 1L;

	public CoordenadorDaoImpl() {
		super(Coordenador.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Coordenador> pesquisarPorNome(String nome) {
			
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select u from Coordenador u where lower(u.nome) like concat(:nome, '%')");
		q.setParameter("nome", nome);
		q.setMaxResults(50);
		
		return q.getResultList();
	}

	@Override
	public Coordenador pesquisarPorCurso(Integer id) {
		
		try{
			
			EntityManager em = emf.createEntityManager();
			Query q = em.createQuery("select u from Coordenador u where u.curso.id = :id");
			q.setParameter("id", id);
			
			return (Coordenador) q.getSingleResult();
			
		}catch(Exception e){}	
					
		return null;
	}
}
