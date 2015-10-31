package ifpr.pessoa.usuario.colaborador.dao;

import ifpr.dao.Dao;
import ifpr.pessoa.usuario.colaborador.Colaborador;
			
public interface ColaboradorDao extends Dao<Colaborador>{
	
	public Colaborador pesquisarPorNome(String nome);
	public Colaborador pesquisarPorEmail(String email);
	public Colaborador pesquisarPorSiape(String siape);
	public Colaborador pesquisarPorCpf(String cpf);

}

