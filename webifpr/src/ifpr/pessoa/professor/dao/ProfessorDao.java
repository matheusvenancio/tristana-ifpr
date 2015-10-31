package ifpr.pessoa.professor.dao;

import java.util.List;

import ifpr.dao.Dao;
import ifpr.pessoa.Pessoa;
import ifpr.pessoa.professor.Professor;

public interface ProfessorDao extends Dao<Professor>{

	public List<Pessoa> pesquisarPorNome(String nome);
}
