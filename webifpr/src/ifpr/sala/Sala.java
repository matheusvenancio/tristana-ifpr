package ifpr.sala;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbSala")
public class Sala {

	@Column(name = "id_sala")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name = "nome_sala", unique= true)
	private String nome; 
	@Column(name = "area_sala")
	private Integer area;
	@Column(name = "capacidade_sala")
	private Integer capacidade;
	@Column(name = "ano_criacao_sala")
	@Temporal(TemporalType.DATE)
	private Date ano;
	
	public Sala(){
		ano = new Date();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Date getAno() {
		return ano;
	}
	public void setAno(Date ano) {
		this.ano = ano;
	}
	
	@Override
	public String toString() {
		
		return this.nome;
	}
}
