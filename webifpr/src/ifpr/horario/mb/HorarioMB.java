package ifpr.horario.mb;

import ifpr.horario.Horario;
import ifpr.horario.HorarioLazyDataModel;
import ifpr.horario.dao.HorarioDao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "horarioMB")
@ViewScoped
public class HorarioMB {

	@ManagedProperty(value = "#{horarioDao}")
	private HorarioDao horarioDao;

	private Horario horario;

	public HorarioMB() {
		horariosFiltered = new ArrayList<Horario>();
	}

	@ManagedProperty(value = "#{horarioLazyDataModel}")
	private HorarioLazyDataModel horarioLazyDataModel;

	private List<Horario> horariosFiltered;

	public HorarioDao getHorarioDao() {
		return horarioDao;
	}

	public void setHorarioDao(HorarioDao horarioDao) {
		this.horarioDao = horarioDao;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public HorarioLazyDataModel getHorarioLazyDataModel() {
		return horarioLazyDataModel;
	}

	public void setHorarioLazyDataModel(
			HorarioLazyDataModel horarioLazyDataModel) {
		this.horarioLazyDataModel = horarioLazyDataModel;
	}

	public List<Horario> getHorariosFiltered() {
		return horariosFiltered;
	}

	public void setHorariosFiltered(List<Horario> horariosFiltered) {
		this.horariosFiltered = horariosFiltered;
	}

	public void criar() {

		horario = new Horario();
	}

	public void salvar() {

		if (horario.getId() != null) {

			horarioDao.update(horario);

		} else {

			horarioDao.salvar(horario);
		}
	}

	public void remover() {
		horarioDao.remover(horario);
	}

	public void cancelar() {
		horario = null;
	}
	
	
}
