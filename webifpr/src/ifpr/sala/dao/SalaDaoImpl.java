package ifpr.sala.dao;


import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ifpr.dao.GenericDao;
import ifpr.sala.Sala;


@ManagedBean(name="salaDao")
@ApplicationScoped
public class SalaDaoImpl extends GenericDao<Sala> implements SalaDao {

	private static final long serialVersionUID = 1L;
	
	public SalaDaoImpl() {
		super(Sala.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sala> pesquisarPorNome(String nome) {
			
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select s from Sala s where lower(s.nome) like concat(:nome, '%')");
		q.setParameter("nome", nome);
		q.setMaxResults(50);
	
		
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sala> pesquisarPorCapacidade(String capacidade) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select s from Sala s where lower(s.capacidade) like concat(:capacidade)");
		q.setParameter("capacidade", capacidade);
		
		return q.getResultList();
	}

}
