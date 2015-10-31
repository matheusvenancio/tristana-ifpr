package ifpr.materia;

import ifpr.materia.dao.MateriaDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "materiaLazyDataModel")
@ViewScoped
public class MateriaLazyDataModel extends LazyDataModel<Materia> {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{materiaDao}")
	private MateriaDao materiaDao;

	public MateriaLazyDataModel() {

	}

	

	@Override
	public Materia getRowData(String rowKey) {
		return materiaDao.findById(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Materia materia) {
		return materia.getId();
	}

	@Override
	public List<Materia> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		List<Materia> source = null;

		source = materiaDao.list(first, pageSize);

		// sort
		if (sortField != null) {
			Collections.sort(source, new LazyMateriaSorter(sortField, sortOrder));
		}

		// rowCount
		this.setRowCount(materiaDao.getRowCount());

		return source;
	}
	
	public MateriaDao getMateriaDao() {
		return materiaDao;
	}

	public void setMateriaDao(MateriaDao materiaDao) {
		this.materiaDao = materiaDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
