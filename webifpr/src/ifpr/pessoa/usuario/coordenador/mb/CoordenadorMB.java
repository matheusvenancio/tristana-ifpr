package ifpr.pessoa.usuario.coordenador.mb;


import ifpr.pessoa.professor.Professor;
import ifpr.pessoa.usuario.coordenador.Coordenador;
import ifpr.pessoa.usuario.coordenador.CoordenadorLazyDataModel;
import ifpr.pessoa.usuario.coordenador.dao.CoordenadorDao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="coordenadorMB")
@ViewScoped
public class CoordenadorMB {

	@ManagedProperty(value="#{coordenadorDao}")
	private CoordenadorDao coordenadorDao;
	
	private Coordenador coordenador;
	
	private Professor professor;
	
	@ManagedProperty(value="#{coordenadorLazyDataModel}")
	private CoordenadorLazyDataModel coordenadorLazyDataModel;
	
	private List<Coordenador> coordenadorFiltered;

	public CoordenadorMB(){
		coordenadorFiltered = new ArrayList<Coordenador>();
	}
		
	public CoordenadorDao getCoordenadorDao() {
		return coordenadorDao;
	}

	public void setCoordenadorDao(CoordenadorDao coordenadorDao) {
		this.coordenadorDao = coordenadorDao;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public CoordenadorLazyDataModel getCoordenadorLazyDataModel() {
		return coordenadorLazyDataModel;
	}

	public void setCoordenadorLazyDataModel(
			CoordenadorLazyDataModel coordenadorLazyDataModel) {
		this.coordenadorLazyDataModel = coordenadorLazyDataModel;
	}

	public List<Coordenador> getCoordenadorFiltered() {
		return coordenadorFiltered;
	}

	public void setCoordenadorFiltered(List<Coordenador> coordenadorFiltered) {
		this.coordenadorFiltered = coordenadorFiltered;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void criar() {
		coordenador = new Coordenador();
	}

	public void salvar() {
	
		if (coordenador.getId() != null) {
			coordenadorDao.update(coordenador);

		} else {
			coordenador.setId(professor.getId());
			coordenadorDao.salvar(coordenador);
		}
	}
	
	
	public void remover() {
		coordenadorDao.remover(coordenador);
	}

	public void cancelar() {
		coordenador = null;
	}
}
