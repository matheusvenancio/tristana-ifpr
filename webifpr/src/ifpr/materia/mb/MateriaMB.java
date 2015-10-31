package ifpr.materia.mb;

import java.util.ArrayList;
import java.util.List;

import ifpr.materia.Materia;
import ifpr.materia.MateriaLazyDataModel;
import ifpr.materia.dao.MateriaDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="materiaMB")
@ViewScoped
public class MateriaMB {

	@ManagedProperty(value="#{materiaDao}")
	private MateriaDao materiaDao;
	
	private Materia materia;
	

	
	public MateriaMB(){
		materiasFiltered = new ArrayList<Materia>();
	
	}

	@ManagedProperty(value="#{materiaLazyDataModel}")
	private MateriaLazyDataModel materiaLazyDataModel;
	
	private List<Materia> materiasFiltered;

	public MateriaDao getMateriaDao() {
		return materiaDao;
	}

	public void setMateriaDao(MateriaDao materiaDao) {
		this.materiaDao = materiaDao;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public MateriaLazyDataModel getMateriaLazyDataModel() {
		return materiaLazyDataModel;
	}

	public void setMateriaLazyDataModel(MateriaLazyDataModel materiaLazyDataModel) {
		this.materiaLazyDataModel = materiaLazyDataModel;
	}

	public List<Materia> getMateriasFiltered() {
		return materiasFiltered;
	}

	public void setMateriasFiltered(List<Materia> materiasFiltered) {
		this.materiasFiltered = materiasFiltered;
	}
	
	public void criar() {
		
		materia = new Materia();
	}

	public void salvar() {

		if (materia.getId() != null) {

			materiaDao.update(materia);

		} else {

			materiaDao.salvar(materia);
		}
	}
	

	public void remover() {
		materiaDao.remover(materia);
	}

	public void cancelar() {
		materia = null;
	}
	
	

	
}
