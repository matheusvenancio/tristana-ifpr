package ifpr.sala;

import ifpr.sala.dao.SalaDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "salaLazyDataModel")
@ViewScoped
public class SalaLazyDataModel extends LazyDataModel<Sala> {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{salaDao}")
	private SalaDao salaDao;

	public SalaLazyDataModel() {

	}

	@Override
	public Sala getRowData(String rowKey) {
		return salaDao.findById(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Sala sala) {
		return sala.getId();
	}

	@Override
	public List<Sala> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		List<Sala> source = null;

		source = salaDao.list(first, pageSize);
		
		if(filters.containsKey("nome")){
			
			String nomePesquisa = filters.get("nome").toString();
		
			source = salaDao.pesquisarPorNome(nomePesquisa);
			
			
		} else if(filters.containsKey("capacidade")){
				
			String capacidadePesquisa = filters.get("capacidade").toString();
			source = salaDao.pesquisarPorCapacidade(capacidadePesquisa);
			
		} else {
				source = salaDao.list(first, pageSize);
		}
			
		// sort
		if (sortField != null) {
			Collections.sort(source, new LazySalaSorter(sortField, sortOrder));
		}

		// rowCount
		this.setRowCount(salaDao.getRowCount());

		return source;
	}
	
	public SalaDao getSalaDao() {
		return salaDao;
	}

	public void setSalaDao(SalaDao salaDao) {
		this.salaDao = salaDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
