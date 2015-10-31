package ifpr.pessoa.professor.mb;

import ifpr.pessoa.dao.PessoaDao;
import ifpr.pessoa.professor.Professor;
import ifpr.pessoa.professor.ProfessorLazyDataModel;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="professorMB")
@ViewScoped
public class ProfessorMB {

	@ManagedProperty(value="#{pessoaDao}")
	private PessoaDao pessoaDao;
	
	private Professor professor;
	
	@ManagedProperty(value="#{professorLazyDataModel}")
	private ProfessorLazyDataModel professorLazyDataModel;
	
	private List<Professor> professoresFiltered;

	public ProfessorMB(){
		professoresFiltered = new ArrayList<Professor>();
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public ProfessorLazyDataModel getProfessorLazyDataModel() {
		return professorLazyDataModel;
	}

	public void setProfessorLazyDataModel(
			ProfessorLazyDataModel professorLazyDataModel) {
		this.professorLazyDataModel = professorLazyDataModel;
	}

	public List<Professor> getProfessoresFiltered() {
		return professoresFiltered;
	}

	public void setProfessoresFiltered(List<Professor> professoresFiltered) {
		this.professoresFiltered = professoresFiltered;
	}

	public void criar() {
		professor= new Professor();
	}

	public void salvar() {
		if (professor.getId() != null) {
			pessoaDao.update(professor);

		} else {
			pessoaDao.salvar(professor);
		}
	}
	
	public void remover() {
		pessoaDao.remover(professor);
	}

	public void cancelar() {
		professor = null;
	}
}
