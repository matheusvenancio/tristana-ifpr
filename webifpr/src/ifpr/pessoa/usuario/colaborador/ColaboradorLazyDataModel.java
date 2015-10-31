package ifpr.pessoa.usuario.colaborador;

import ifpr.pessoa.usuario.colaborador.dao.ColaboradorDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "colaboradorLazyDataModel")
@ViewScoped
public class ColaboradorLazyDataModel extends LazyDataModel<Colaborador> {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{colaboradorDao}")
	private ColaboradorDao colaboradorDao;

	public ColaboradorLazyDataModel() {

	}

	@Override
	public Colaborador getRowData(String rowKey) {
		return colaboradorDao.findById(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Colaborador colaborador) {
		return colaborador.getId();
	}

	@Override
	public List<Colaborador> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		List<Colaborador> source = null;

		source = colaboradorDao.list(first, pageSize);
		
		if(filters.containsKey("nome")){
			
			String nomePesquisa = filters.get("nome").toString();
			
			source = new ArrayList<Colaborador>();
			source.add( colaboradorDao.pesquisarPorNome(nomePesquisa) );
			
			
		} 
		else if(filters.containsKey("siape")){
				
			String siapePesquisa = filters.get("siape").toString();
			
			source = new ArrayList<Colaborador>();
			source.add( colaboradorDao.pesquisarPorSiape(siapePesquisa) );
			
		} 
		else if(filters.containsKey("email")){
			
			String emailPesquisa = filters.get("email").toString();
			
			source = new ArrayList<Colaborador>();
			source.add( colaboradorDao.pesquisarPorEmail(emailPesquisa) );
			
		} 
		else {
				source = colaboradorDao.list(first, pageSize);
		}
			
		// sort
		if (sortField != null) {
			Collections.sort(source, new LazyColaboradorSorter(sortField, sortOrder));
		}

		// rowCount
		this.setRowCount(colaboradorDao.getRowCount());

		return source;
	}
	
	public ColaboradorDao getColaboradorDao() {
		return colaboradorDao;
	}

	public void setColaboradorDao(ColaboradorDao colaboradorDao) {
		this.colaboradorDao = colaboradorDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
