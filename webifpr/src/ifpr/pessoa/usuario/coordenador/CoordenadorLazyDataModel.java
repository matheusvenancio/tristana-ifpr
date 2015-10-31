package ifpr.pessoa.usuario.coordenador;



import ifpr.pessoa.usuario.coordenador.dao.CoordenadorDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "coordenadorLazyDataModel")
@ViewScoped
public class CoordenadorLazyDataModel extends LazyDataModel<Coordenador> {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{coordenadorDao}")
	private CoordenadorDao coordenadorDao;

	@Override
	public Coordenador getRowData(String rowKey) {
		return (Coordenador) coordenadorDao.findById(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Coordenador coordenador) {
		return coordenador.getId();
	}

	@Override
	public List<Coordenador> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		List<Coordenador> source = null;

		source = coordenadorDao.list(first, pageSize);

		// sort
		if (sortField != null) {
			Collections.sort(source, new LazyCoordenadorSorter(sortField, sortOrder));
		}

		// rowCount
		this.setRowCount(coordenadorDao.getRowCount());

		return source;
	}
	


	public CoordenadorDao getCoordenadorDao() {
		return coordenadorDao;
	}

	public void setCoordenadorDao(CoordenadorDao coordenadorDao) {
		this.coordenadorDao = coordenadorDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
