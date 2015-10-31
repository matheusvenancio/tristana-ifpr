package ifpr.objeto.categoria.mb;

import ifpr.objeto.categoria.Categoria;
import ifpr.objeto.categoria.CategoriaLazyDataModel;
import ifpr.objeto.categoria.dao.CategoriaDao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="categoriaMB")
@ViewScoped
public class CategoriaMB {
	
	@ManagedProperty(value="#{categoriaDao}")
	private CategoriaDao categoriaDao;
	
	private Categoria categoria;
	

	
	public CategoriaMB(){
		categoriasFiltered = new ArrayList<Categoria>();
	
	}

	@ManagedProperty(value="#{categoriaLazyDataModel}")
	private CategoriaLazyDataModel categoriaLazyDataModel;
	
	private List<Categoria> categoriasFiltered;

	public CategoriaDao getCategoriaDao() {
		return categoriaDao;
	}

	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public CategoriaLazyDataModel getCategoriaLazyDataModel() {
		return categoriaLazyDataModel;
	}

	public void setCategoriaLazyDataModel(CategoriaLazyDataModel categoriaLazyDataModel) {
		this.categoriaLazyDataModel = categoriaLazyDataModel;
	}

	public List<Categoria> getCategoriasFiltered() {
		return categoriasFiltered;
	}

	public void setCategoriasFiltered(List<Categoria> categoriasFiltered) {
		this.categoriasFiltered = categoriasFiltered;
	}
	
	public void criar() {
		
		categoria = new Categoria();
	}

	public void salvar() {

		if (categoria.getId() != null) {

			categoriaDao.update(categoria);

		} else {

			categoriaDao.salvar(categoria);
		}
	}
	

	public void remover() {
		categoriaDao.remover(categoria);
	}

	public void cancelar() {
		categoria = null;
	}

}
