package ifpr.pessoa.usuario.coordenador.dao;

import java.util.List;

import ifpr.dao.Dao;
import ifpr.pessoa.usuario.coordenador.Coordenador;
			
public interface CoordenadorDao extends Dao<Coordenador>{
	
	public List<Coordenador> pesquisarPorNome(String nome);
	public Coordenador pesquisarPorCurso(Integer id);
}

