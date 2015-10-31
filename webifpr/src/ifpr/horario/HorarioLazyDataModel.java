package ifpr.horario;

import ifpr.horario.dao.HorarioDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "horarioLazyDataModel")
@ViewScoped
public class HorarioLazyDataModel extends LazyDataModel<Horario> {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{horarioDao}")
	private HorarioDao horarioDao;

	public HorarioLazyDataModel() {

	}

	@Override
	public Horario getRowData(String rowKey) {
		return horarioDao.findById(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Horario horario) {
		return horario.getId();
	}

	@Override
	public List<Horario> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		List<Horario> source = null;

		source = horarioDao.list(first, pageSize);

		// sort
		if (sortField != null) {
			Collections.sort(source, new LazyHorarioSorter(sortField, sortOrder));
		}

		// rowCount
		this.setRowCount(horarioDao.getRowCount());

		return source;
	}
	
	public HorarioDao getHorarioDao() {
		return horarioDao;
	}

	public void setHorarioDao(HorarioDao horarioDao) {
		this.horarioDao = horarioDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
