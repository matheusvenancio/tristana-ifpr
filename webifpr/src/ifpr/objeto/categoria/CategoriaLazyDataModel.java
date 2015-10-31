package ifpr.objeto.categoria;

import ifpr.objeto.categoria.dao.CategoriaDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "categoriaLazyDataModel")
@ViewScoped
public class CategoriaLazyDataModel extends LazyDataModel<Categoria> {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{categoriaDao}")
	private CategoriaDao categoriaDao;

	public CategoriaLazyDataModel() {

	}

	

	@Override
	public Categoria getRowData(String rowKey) {
		return categoriaDao.findById(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Categoria categoria) {
		return categoria.getId();
	}

	@Override
	public List<Categoria> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		List<Categoria> source = null;

		source = categoriaDao.list(first, pageSize);

		// sort
		if (sortField != null) {
			Collections.sort(source, new LazyCategoriaSorter(sortField, sortOrder));
		}

		// rowCount
		this.setRowCount(categoriaDao.getRowCount());

		return source;
	}
	
	public CategoriaDao getCategoriaDao() {
		return categoriaDao;
	}

	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
