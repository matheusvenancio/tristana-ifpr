package ifpr.pessoa.usuario.colaborador.mb;

import ifpr.criptografia.Criptografia;
import ifpr.pessoa.usuario.colaborador.Colaborador;
import ifpr.pessoa.usuario.colaborador.ColaboradorLazyDataModel;
import ifpr.pessoa.usuario.colaborador.dao.ColaboradorDao;
import ifpr.pessoa.validador.PessoaValidador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "colaboradorMB")
@ViewScoped
public class ColaboradorMB {

	@ManagedProperty(value = "#{colaboradorDao}")
	private ColaboradorDao colaboradorDao;

	private Criptografia criptografia;
	
	@ManagedProperty(value = "#{pessoaValidador}")
	private PessoaValidador pessoaValidador;

	private Colaborador colaborador;

	@ManagedProperty(value = "#{colaboradorLazyDataModel}")
	private ColaboradorLazyDataModel colaboradorLazyDataModel;

	private List<Colaborador> colaboradoresFiltered;

	public ColaboradorMB() {
		criptografia = new Criptografia();
		colaboradoresFiltered = new ArrayList<Colaborador>();
	}

	public ColaboradorDao getColaboradorDao() {
		return colaboradorDao;
	}

	public void setColaboradorDao(ColaboradorDao colaboradorDao) {
		this.colaboradorDao = colaboradorDao;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public ColaboradorLazyDataModel getColaboradorLazyDataModel() {
		return colaboradorLazyDataModel;
	}

	public void setColaboradorLazyDataModel(
			ColaboradorLazyDataModel colaboradorLazyDataModel) {
		this.colaboradorLazyDataModel = colaboradorLazyDataModel;
	}

	public List<Colaborador> getColaboradoresFiltered() {
		return colaboradoresFiltered;
	}

	public void setColaboradoresFiltered(List<Colaborador> colaboradoresFiltered) {
		this.colaboradoresFiltered = colaboradoresFiltered;
	}
	
	public PessoaValidador getPessoaValidador() {
		return pessoaValidador;
	}

	public void setPessoaValidador(PessoaValidador pessoaValidador) {
		this.pessoaValidador = pessoaValidador;
	}

	public void criar() {
		colaborador = new Colaborador();
	}

	public void salvar() {
			
		// erro validação
		if(pessoaValidador.validarDados(colaborador)){

			if (colaborador.getId() != null) {
				
				colaboradorDao.update(colaborador);
	
			} else {
	
				colaborador.setLogin(colaborador.getEmail());
				colaborador.setSenha(gerarSenha());
	
				colaboradorDao.salvar(colaborador);
	
			}
		}
	}

	public String gerarSenha() {

		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String senha = "";

		for (int x = 0; x < 10; x++) {

			int j = (int) (Math.random() * carct.length);
			senha += carct[j];
		}

		senha = criptografia.criptografar(senha);

		return senha;
	}
	

	public void remover() {
		colaboradorDao.remover(colaborador);
	}

	public void cancelar() {
		colaborador = null;
	}
	
	
	
	

}




