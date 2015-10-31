package ifpr.sala.mb;

import ifpr.sala.Sala;
import ifpr.sala.SalaLazyDataModel;
import ifpr.sala.dao.SalaDao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;

@ManagedBean(name = "salaMB")
@ViewScoped
public class SalaMB {

	@ManagedProperty(value = "#{salaDao}")
	private SalaDao salaDao;

	private Sala sala;

	public SalaMB() {
		salasFiltered = new ArrayList<Sala>();

	}

	@ManagedProperty(value = "#{salaLazyDataModel}")
	private SalaLazyDataModel salaLazyDataModel;

	private List<Sala> salasFiltered;

	public SalaDao getSalaDao() {
		return salaDao;
	}

	public void setSalaDao(SalaDao salaDao) {
		this.salaDao = salaDao;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public SalaLazyDataModel getSalaLazyDataModel() {
		return salaLazyDataModel;
	}

	public void setSalaLazyDataModel(SalaLazyDataModel salaLazyDataModel) {
		this.salaLazyDataModel = salaLazyDataModel;
	}

	public List<Sala> getSalasFiltered() {
		return salasFiltered;
	}

	public void setSalasFiltered(List<Sala> salasFiltered) {
		this.salasFiltered = salasFiltered;
	}

	public void criar() {

		sala = new Sala();
	}

	public void salvar() {

		if (sala.getId() != null) {

			salaDao.update(sala);

		} else if (validarNome()) {

			salaDao.salvar(sala);
		}
	}

	public void remover() {
		salaDao.remover(sala);
	}

	public void cancelar() {
		sala = null;
	}

	public boolean validarNome() {

		try {
			salaDao.pesquisarPorNome(sala.getNome());
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erro!",
					"Sala já existe, escolha outro");
			FacesContext.getCurrentInstance().addMessage("Atenção", message);
			FacesContext.getCurrentInstance().validationFailed();

			return false;

		} catch (NoResultException e) {
			return true;
		}

	}

}
