package ifpr.turma.dao;

import java.util.List;

import ifpr.dao.GenericDao;
import ifpr.turma.Turma;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;


@ManagedBean(name="turmaDao")
@ApplicationScoped
public class TurmaDaoImpl extends GenericDao<Turma> implements TurmaDao {

	private static final long serialVersionUID = 1L;
	
	public TurmaDaoImpl() {
		super(Turma.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> pesquisarPorNome(String nome) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select t from Turma t where lower(t.nome) like concat(:nome, '%')");
		q.setParameter("nome",nome);
		q.setMaxResults(50);
		
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> pesquisarPorCriacao(String criacao) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select t from Turma t where lower(t.criacao) like concat(:criacao, '%')");
		q.setParameter("criacao",criacao);
		q.setMaxResults(50);
		
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> pesquisarPorCursoCriacao(String curso, String criacao) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select t from Turma t where lower(t.criacao) like concat(:criacao, '%') and lower(t.curso) in (select c from Curso c where lower(c.nome) like concat(:curso,'%')) ");
		q.setParameter("curso", curso);
		q.setParameter("criacao", criacao);
		
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> pesquisarPorCurso(String curso) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select t from Turma t where lower(t.curso) in (select c from Curso c where lower(c.nome) like concat(:curso,'%')) ");
		q.setParameter("curso",curso);
		q.setMaxResults(50);
		
		return q.getResultList();
	}
}
