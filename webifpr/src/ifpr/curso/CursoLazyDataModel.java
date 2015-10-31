package ifpr.curso;

import ifpr.curso.dao.CursoDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "cursoLazyDataModel")
@ViewScoped
public class CursoLazyDataModel extends LazyDataModel<Curso> {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{cursoDao}")
	private CursoDao cursoDao;

	public CursoLazyDataModel() {

	}

	@Override
	public Curso getRowData(String rowKey) {
		return cursoDao.findById(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Curso curso) {
		return curso.getId();
	}

	@Override
	public List<Curso> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		List<Curso> source = null;

		source = cursoDao.list(first, pageSize);
		
		// sort
		if (sortField != null) {
			Collections.sort(source, new LazyCursoSorter(sortField, sortOrder));
		}

		// rowCount
		this.setRowCount(cursoDao.getRowCount());

		return source;
	}
	
	public CursoDao getCursoDao() {
		return cursoDao;
	}

	public void setCursoDao(CursoDao cursoDao) {
		this.cursoDao = cursoDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
