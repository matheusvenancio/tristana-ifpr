package ifpr.pessoa.validador;

import ifpr.pessoa.Pessoa;
import ifpr.pessoa.dao.PessoaDao;

import java.util.InputMismatchException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;

@ManagedBean(name = "pessoaValidador")
@ViewScoped
public class PessoaValidador {

	@ManagedProperty(value = "#{pessoaDao}")
	private PessoaDao pessoaDao;

	private Pessoa pessoa;

	public boolean validarDados(Pessoa pessoa) {

		this.pessoa = pessoa;
		boolean valido = true;

		if (!validarSiape()) {
			valido = false;
		}

		if (!validarCpf()) {
			valido = false;
		}

		return valido;
	}

	private boolean validarSiape() {

		try {
			
			if(pessoa.getId() == null){

				pessoaDao.pesquisarPorSiape(pessoa.getSiape());
			}else {
				pessoaDao.pesquisarPorSiape(pessoa.getSiape(), pessoa.getId());
			}

			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erro!",
					"Siape já existe, escolha outro");

			context.addMessage("Atenção", message);
			context.validationFailed();

			UIInput input = (UIInput) context.getViewRoot().findComponent(
					":dadosForm:siape");
			input.setValid(false);

			return false;

		} catch (NoResultException e) {

			return true;
		}

	}

	private boolean validarCpf() {

		if (isCPF(pessoa.getCpf())) {
			
			try {

				if (pessoa.getId() == null) {
		
					pessoaDao.pesquisarPorCpf(pessoa.getCpf());
				}else {
					
					pessoaDao.pesquisarPorCpf(pessoa.getCpf(), pessoa.getId());
				}
				
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erro!",
						"CPF já cadastrado, escolha outro");

				context.addMessage("Atenção", message);
				context.validationFailed();

				UIInput input = (UIInput) context.getViewRoot()
						.findComponent(":dadosForm:cpf");
				input.setValid(false);

				return false;

			} catch (NoResultException e) {

				return true;
			}
											
		} else {

			invalidarCpf();
			
			return false;
		}
	}

	private void invalidarCpf() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, "Erro!", "CPF inválido.");

		context.addMessage("Atenção", message);
		context.validationFailed();

		UIInput input = (UIInput) context.getViewRoot().findComponent(
				":dadosForm:cpf");
		input.setValid(false);
	}

	private static boolean isCPF(String CPF) {

		if (CPF.equals("00000000000") || CPF.equals("11111111111")
				|| CPF.equals("22222222222") || CPF.equals("33333333333")
				|| CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777")
				|| CPF.equals("88888888888") || CPF.equals("99999999999")
				|| (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {

			sm = 0;
			peso = 10;

			for (i = 0; i < 9; i++) {

				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);

			if ((r == 10) || (r == 11)) {

				dig10 = '0';

			} else {
				dig10 = (char) (r + 48);
			}

			sm = 0;
			peso = 11;

			for (i = 0; i < 10; i++) {

				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;

			}

			r = 11 - (sm % 11);

			if ((r == 10) || (r == 11)) {

				dig11 = '0';

			} else {

				dig11 = (char) (r + 48);
			}

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
				return (true);
			} else {
				return (false);
			}

		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

}
