package ifpr.turma;

import ifpr.turma.dao.TurmaDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "turmaLazyDataModel")
@ViewScoped
public class TurmaLazyDataModel extends LazyDataModel<Turma> {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{turmaDao}")
	private TurmaDao turmaDao;

	public TurmaLazyDataModel() {

	}

	@Override
	public Turma getRowData(String rowKey) {
		return turmaDao.findById(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Turma turma) {
		return turma.getId();
	}

	@Override
	public List<Turma> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		List<Turma> source = null;

		source = turmaDao.list(first, pageSize);
		
        if (filters.containsKey("criacao") && filters.containsKey("curso") )
        {
        	String criacaoPesquisa = filters.get("criacao").toString();
        	String cursoPesquisa = filters.get("curso").toString();
        	
        	source = turmaDao.pesquisarPorCursoCriacao(cursoPesquisa, criacaoPesquisa);
        	
        } else if(filters.containsKey("criacao") ){
        	
        	String criacaoPesquisa = filters.get("criacao").toString();
        	source = turmaDao.pesquisarPorCriacao(criacaoPesquisa);
        
        } else if(filters.containsKey("curso")){
        	
        	String cursoPesquisa = filters.get("curso").toString();
        	source = turmaDao.pesquisarPorCurso(cursoPesquisa);
        
        } else {
        	source = turmaDao.list(first, pageSize);
        }

		// sort
		if (sortField != null) {
			Collections.sort(source, new LazyTurmaSorter(sortField, sortOrder));
		}

		// rowCount
		this.setRowCount(turmaDao.getRowCount());

		return source;
	}
	
	public TurmaDao getTurmaDao() {
		return turmaDao;
	}

	public void setTurmaDao(TurmaDao turmaDao) {
		this.turmaDao = turmaDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
