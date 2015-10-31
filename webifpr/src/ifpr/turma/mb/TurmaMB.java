package ifpr.turma.mb;

import ifpr.curso.Curso;
import ifpr.curso.dao.CursoDao;
import ifpr.turma.Turma;
import ifpr.turma.TurmaLazyDataModel;
import ifpr.turma.dao.TurmaDao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="turmaMB")
@ViewScoped
public class TurmaMB {

	@ManagedProperty(value="#{turmaDao}")
	private TurmaDao turmaDao;
	
	@ManagedProperty(value="#{cursoDao}")
	private CursoDao cursoDao;
	
	private Turma turma;
	
	private Curso curso;
	
	@ManagedProperty(value="#{turmaLazyDataModel}")
	private TurmaLazyDataModel turmaLazyDataModel;
	
	private List<Turma> turmaFiltered;
	
	public TurmaMB(){
		turmaFiltered = new ArrayList<Turma>();
	}
	
	public TurmaDao getTurmaDao() {
		return turmaDao;
	}

	public void setTurmaDao(TurmaDao turmaDao) {
		this.turmaDao = turmaDao;
	}

	public CursoDao getCursoDao() {
		return cursoDao;
	}

	public void setCursoDao(CursoDao cursoDao) {
		this.cursoDao = cursoDao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public TurmaLazyDataModel getTurmaLazyDataModel() {
		return turmaLazyDataModel;
	}

	public void setTurmaLazyDataModel(TurmaLazyDataModel turmaLazyDataModel) {
		this.turmaLazyDataModel = turmaLazyDataModel;
	}

	public List<Turma> getTurmaFiltered() {
		return turmaFiltered;
	}

	public void setTurmaFiltered(List<Turma> turmaFiltered) {
		this.turmaFiltered = turmaFiltered;
	}

	public void criar() {
		turma = new Turma();
		curso = new Curso();
	}
	
	public void editar(){
		curso = turma.getCurso();
	}
	
	public void salvar() {

		turma.setCurso(curso);
		turma.setNome(curso.getNome() + " " + turma.getCriacao());
		
		if (turma.getId() != null) {
			turmaDao.update(turma);
		} else {
			turmaDao.salvar(turma);
		}
	}
	
	public void remover() {
		turmaDao.remover(turma);
	}

	public void cancelar() {
		turma = null;
	}	
}
