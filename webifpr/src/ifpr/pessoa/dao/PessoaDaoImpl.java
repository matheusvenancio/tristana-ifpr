package ifpr.pessoa.dao;

import ifpr.dao.GenericDao;
import ifpr.pessoa.Pessoa;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean(name="pessoaDao")
@ApplicationScoped
public class PessoaDaoImpl extends GenericDao<Pessoa> implements PessoaDao {

	private static final long serialVersionUID = 1L;

	public PessoaDaoImpl() {
		super(Pessoa.class);
	}

	@Override
	public Pessoa pesquisarPorNome(String nome) {
			
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Pessoa c where c.nome = :nome");
		q.setParameter("nome", nome);
	
			
		return (Pessoa) q.getSingleResult();
	}
	
	@Override
	public Pessoa pesquisarPorCpf(String cpf) {
			
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Pessoa c where c.cpf = :cpf)");
		q.setParameter("cpf", cpf);
	
		
		return (Pessoa) q.getSingleResult();
	}
	
	@Override
	public Pessoa pesquisarPorCpf(String cpf, Integer id) {
			
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Pessoa c where c.cpf = :cpf and c.id != :id");
		q.setParameter("cpf", cpf);
		q.setParameter("id", id);
	
		
		return (Pessoa) q.getSingleResult();
	}

	@Override
	public Pessoa pesquisarPorEmail(String email) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Pessoa c where c.email = :email");
		q.setParameter("email", email);
			
		return (Pessoa) q.getSingleResult();
	}

	@Override
	public Pessoa pesquisarPorSiape(String siape) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Pessoa c where c.siape = :siape");
		q.setParameter("siape", siape);
	
		return (Pessoa) q.getSingleResult();
	}

	@Override
	public Pessoa pesquisarPorSiape(String siape, Integer id) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Pessoa c where c.siape = :siape and c.id != :id");
		q.setParameter("siape", siape);
		q.setParameter("id", id);
	
		return (Pessoa) q.getSingleResult();
	}

}
