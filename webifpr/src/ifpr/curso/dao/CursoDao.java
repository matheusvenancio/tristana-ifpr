package ifpr.curso.dao;

import java.util.List;

import ifpr.curso.Curso;
import ifpr.dao.Dao;

public interface CursoDao extends Dao<Curso>{
	
	public List<Curso> pesquisarPorNome(String nome);
	
	public Curso pesquisarPorCoordenador(Integer id);
	

}
