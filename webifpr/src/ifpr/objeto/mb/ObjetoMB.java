package ifpr.objeto.mb;


import ifpr.objeto.Objeto;
import ifpr.objeto.ObjetoLazyDataModel;
import ifpr.objeto.categoria.Categoria;
import ifpr.objeto.categoria.dao.CategoriaDao;
import ifpr.objeto.dao.ObjetoDao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="objetoMB")
@ViewScoped
public class ObjetoMB {

	@ManagedProperty(value="#{objetoDao}")
	private ObjetoDao objetoDao;
	
	@ManagedProperty(value="#{categoriaDao}")
	private CategoriaDao categoriaDao;
	
	private Objeto objeto;
	
	private Categoria categoria;
	
	@ManagedProperty(value="#{objetoLazyDataModel}")
	private ObjetoLazyDataModel objetoLazyDataModel;
	
	private List<Objeto> objetoFiltered;
	
	public ObjetoMB(){
		objetoFiltered = new ArrayList<Objeto>();
	}
	
	public ObjetoDao getObjetoDao() {
		return objetoDao;
	}

	public void setObjetoDao(ObjetoDao objetoDao) {
		this.objetoDao = objetoDao;
	}

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

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public ObjetoLazyDataModel getObjetoLazyDataModel() {
		return objetoLazyDataModel;
	}

	public void setObjetoLazyDataModel(ObjetoLazyDataModel objetoLazyDataModel) {
		this.objetoLazyDataModel = objetoLazyDataModel;
	}

	public List<Objeto> getObjetoFiltered() {
		return objetoFiltered;
	}

	public void setObjetoFiltered(List<Objeto> objetoFiltered) {
		this.objetoFiltered = objetoFiltered;
	}

	public void criar() {
		objeto = new Objeto();
		categoria = new Categoria();
	}
	
	public void editar(){
		categoria = objeto.getCategoria();
	}
	
	public void salvar() {

		objeto.setCategoria(categoria);
		
		if (objeto.getId() != null) {
			objetoDao.update(objeto);
		} else {
			objetoDao.salvar(objeto);
		}
	}
	
	public void remover() {
		objetoDao.remover(objeto);
	}

	public void cancelar() {
		objeto = null;
	}	
}
