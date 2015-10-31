package ifpr.pessoa.professor;

import ifpr.pessoa.professor.dao.ProfessorDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "professorLazyDataModel")
@ViewScoped
public class ProfessorLazyDataModel extends LazyDataModel<Professor> {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{professorDao}")
	private ProfessorDao professorDao;

	@Override
	public Professor getRowData(String rowKey) {
		return (Professor) professorDao.findById(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Professor professor) {
		return professor.getId();
	}

	@Override
	public List<Professor> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		List<Professor> source = null;

		source = professorDao.list(first, pageSize);

		// sort
		if (sortField != null) {
			Collections.sort(source, new LazyProfessorSorter(sortField, sortOrder));
		}

		// rowCount
		this.setRowCount(professorDao.getRowCount());

		return source;
	}
	


	public ProfessorDao getProfessorDao() {
		return professorDao;
	}

	public void setProfessorDao(ProfessorDao professorDao) {
		this.professorDao = professorDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
