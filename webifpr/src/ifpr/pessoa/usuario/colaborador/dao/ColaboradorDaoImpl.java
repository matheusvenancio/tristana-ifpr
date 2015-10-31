package ifpr.pessoa.usuario.colaborador.dao;

import ifpr.dao.GenericDao;
import ifpr.pessoa.usuario.colaborador.Colaborador;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean(name="colaboradorDao")
@ApplicationScoped
public class ColaboradorDaoImpl extends GenericDao<Colaborador> implements ColaboradorDao {

	private static final long serialVersionUID = 1L;

	public ColaboradorDaoImpl() {
		super(Colaborador.class);
	}
	
	@Override
	public Colaborador pesquisarPorNome(String nome) {
			
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Colaborador c where c.nome = :nome");
		q.setParameter("nome", nome);
	
		
		return (Colaborador) q.getSingleResult();
	}
	
	@Override
	public Colaborador pesquisarPorCpf(String cpf) {
			
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Colaborador c where c.cpf = :cpf)");
		q.setParameter("cpf", cpf);
	
		
		return (Colaborador) q.getSingleResult();
	}


	@Override
	public Colaborador pesquisarPorEmail(String email) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Colaborador c where c.email = :email");
		q.setParameter("email", email);
			
		return (Colaborador) q.getSingleResult();
	}

	@Override
	public Colaborador pesquisarPorSiape(String siape) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Colaborador c where c.siape = :siape");
		q.setParameter("siape", siape);
	
		
		return (Colaborador) q.getSingleResult();
	}
}
