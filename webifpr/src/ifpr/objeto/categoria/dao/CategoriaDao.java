package ifpr.objeto.categoria.dao;

import java.util.List;

import ifpr.curso.Curso;
import ifpr.dao.Dao;
import ifpr.objeto.categoria.Categoria;

public interface CategoriaDao extends Dao<Categoria>{
	
	
	public List<Curso> pesquisarPorNome(String nome);

}
