package ifpr.pessoa.dao;

import ifpr.dao.Dao;
import ifpr.pessoa.Pessoa;

public interface PessoaDao extends Dao<Pessoa>{
	
	public Pessoa pesquisarPorNome(String nome);
	public Pessoa pesquisarPorEmail(String email);
	public Pessoa pesquisarPorSiape(String siape);
	public Pessoa pesquisarPorSiape(String siape, Integer id);
	public Pessoa pesquisarPorCpf(String cpf);
	public Pessoa pesquisarPorCpf(String cpf, Integer id);
}
