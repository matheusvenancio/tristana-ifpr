package ifpr.objeto.categoria.dao;

import java.util.List;

import ifpr.curso.Curso;
import ifpr.dao.GenericDao;
import ifpr.objeto.categoria.Categoria;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean(name="categoriaDao")
@ApplicationScoped
public class CategoriaDaoImpl extends GenericDao<Categoria> implements CategoriaDao {

	private static final long serialVersionUID = 1L;
	
	public CategoriaDaoImpl() {
		super(Categoria.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> pesquisarPorNome(String nome) {
			
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select u from Categoria u where lower(u.nome) like concat(:nome, '%')");
		q.setParameter("nome", nome);
		q.setMaxResults(50);
		
		return q.getResultList();
	}	
}

