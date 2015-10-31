package ifpr.turma.dao;

import java.util.List;

import ifpr.dao.Dao;
import ifpr.turma.Turma;

public interface TurmaDao extends Dao<Turma>{
	
	public List<Turma> pesquisarPorCriacao(String criacao);
	
	public List<Turma> pesquisarPorCursoCriacao(String curso, String criacao);
	
	public List<Turma> pesquisarPorCurso(String curso);
	
	public List<Turma> pesquisarPorNome(String nome);
}
