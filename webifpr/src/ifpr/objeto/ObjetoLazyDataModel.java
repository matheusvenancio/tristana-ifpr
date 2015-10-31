package ifpr.objeto;


import ifpr.objeto.dao.ObjetoDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "objetoLazyDataModel")
@ViewScoped
public class ObjetoLazyDataModel extends LazyDataModel<Objeto> {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{objetoDao}")
	private ObjetoDao objetoDao;

	public ObjetoLazyDataModel() {

	}

	@Override
	public Objeto getRowData(String rowKey) {
		return objetoDao.findById(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Objeto objeto) {
		return objeto.getId();
	}

	@Override
	public List<Objeto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		List<Objeto> source = null;

		source = objetoDao.list(first, pageSize);
		
		if(filters.containsKey("categoria")){
        	
        	String categoriaPesquisa = filters.get("categoria").toString();
        	source = objetoDao.pesquisarPorCategoria(categoriaPesquisa);
        
        } else {
        	source = objetoDao.list(first, pageSize);
        }

		// sort
		if (sortField != null) {
			Collections.sort(source, new LazyObjetoSorter(sortField, sortOrder));
		}

		// rowCount
		this.setRowCount(objetoDao.getRowCount());

		return source;
	}
	
	public ObjetoDao getObjetoDao() {
		return objetoDao;
	}

	public void setObjetoDao(ObjetoDao objetoDao) {
		this.objetoDao = objetoDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
