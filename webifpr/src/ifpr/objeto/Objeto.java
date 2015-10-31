package ifpr.objeto;

import ifpr.objeto.categoria.Categoria;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbObjetoPerdido")
public class Objeto {

	@Id
	@Column(name = "id_objeto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "descricao_objeto")
	private String descricao;
	
	@Column(name = "local_encontrado")
	private String localEncontrado;
	
	@Column(name = "data_encontrado")
	@Temporal(TemporalType.DATE)
	private Date dataEncontrado;
	
	@Column(name = "nome_entregador")
	private String nomeEntregador;
	
	@Column(name = "nome_receptor")
	private String nomeReceptor;
	
	@Column(name = "rg_receptor")
	private String rgReceptor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;
	
	public Objeto(){
		dataEncontrado = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalEncontrado() {
		return localEncontrado;
	}

	public void setLocalEncontrado(String localEncontrado) {
		this.localEncontrado = localEncontrado;
	}

	public Date getDataEncontrado() {
		return dataEncontrado;
	}

	public void setDataEncontrado(Date dataEncontrado) {
		this.dataEncontrado = dataEncontrado;
	}

	public String getNomeEntregador() {
		return nomeEntregador;
	}

	public void setNomeEntregador(String nomeEntregador) {
		this.nomeEntregador = nomeEntregador;
	}

	public String getNomeReceptor() {
		return nomeReceptor;
	}

	public void setNomeReceptor(String nomeReceptor) {
		this.nomeReceptor = nomeReceptor;
	}

	public String getRgReceptor() {
		return rgReceptor;
	}

	public void setRgReceptor(String rgReceptor) {
		this.rgReceptor = rgReceptor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
