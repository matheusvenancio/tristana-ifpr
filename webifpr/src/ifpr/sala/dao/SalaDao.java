package ifpr.sala.dao;

import java.util.List;

import ifpr.dao.Dao;
import ifpr.sala.Sala;

public interface SalaDao extends Dao<Sala>{
	
	public List<Sala> pesquisarPorNome(String nome);
	public List<Sala> pesquisarPorCapacidade(String capacidade);
	
}
