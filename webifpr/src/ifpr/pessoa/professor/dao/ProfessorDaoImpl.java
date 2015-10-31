package ifpr.pessoa.professor.dao;

import java.util.List;

import ifpr.dao.GenericDao;
import ifpr.pessoa.Pessoa;
import ifpr.pessoa.professor.Professor;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean(name="professorDao")
@ApplicationScoped
public class ProfessorDaoImpl extends GenericDao<Professor> implements ProfessorDao {

	private static final long serialVersionUID = 1L;

	public ProfessorDaoImpl() {
		super(Professor.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> pesquisarPorNome(String nome) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select prof from Professor prof where lower(prof.nome) like concat(:nome, '%')");
		q.setParameter("nome", nome);
		q.setMaxResults(50);
		
		return q.getResultList();
	}

}
