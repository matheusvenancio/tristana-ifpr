package ifpr.curso.mb;

import java.util.ArrayList;
import java.util.List;

import ifpr.curso.Curso;
import ifpr.curso.CursoLazyDataModel;
import ifpr.curso.dao.CursoDao;
import ifpr.pessoa.usuario.coordenador.Coordenador;
import ifpr.pessoa.usuario.coordenador.dao.CoordenadorDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="cursoMB")
@ViewScoped
public class CursoMB {

	@ManagedProperty(value="#{cursoDao}")
	private CursoDao cursoDao;
	
	@ManagedProperty(value="#{coordenadorDao}")
	private CoordenadorDao coordenadorDao;
	
	private Curso curso;
	
	public CursoMB(){
		cursosFiltered = new ArrayList<Curso>();
	}

	@ManagedProperty(value="#{cursoLazyDataModel}")
	private CursoLazyDataModel cursoLazyDataModel;
	
	private List<Curso> cursosFiltered;

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

	public CursoLazyDataModel getCursoLazyDataModel() {
		return cursoLazyDataModel;
	}

	public void setCursoLazyDataModel(CursoLazyDataModel cursoLazyDataModel) {
		this.cursoLazyDataModel = cursoLazyDataModel;
	}

	public List<Curso> getCursosFiltered() {
		return cursosFiltered;
	}

	public void setCursosFiltered(List<Curso> cursosFiltered) {
		this.cursosFiltered = cursosFiltered;
	}
	
	public void criar() {
	
		curso = new Curso();
	}

	public void salvar() {
		
	
		if (curso.getId() != null) {

			cursoDao.update(curso);

		} else {
	
			cursoDao.salvar(curso);
		}
	}
	
	public void remover() {
		cursoDao.remover(curso);
	}

	public void cancelar() {
		curso = null;
	}
	
	public String  getCoordenador(Curso crs){
		
		Coordenador coordenador = coordenadorDao.pesquisarPorCurso(crs.getId());
		
		if( coordenador != null) {
			
			return coordenador.getNome();
		}
		
		return "--";
	}

	public CoordenadorDao getCoordenadorDao() {
		return coordenadorDao;
	}

	public void setCoordenadorDao(CoordenadorDao coordenadorDao) {
		this.coordenadorDao = coordenadorDao;
	}

}
