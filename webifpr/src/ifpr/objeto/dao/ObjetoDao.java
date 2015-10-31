package ifpr.objeto.dao;

import ifpr.dao.Dao;
import ifpr.objeto.Objeto;

import java.util.List;

public interface ObjetoDao extends Dao<Objeto>{
	
	public List<Objeto> pesquisarPorCategoria(String categoria);

}
