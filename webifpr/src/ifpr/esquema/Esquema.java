package ifpr.esquema;

import ifpr.esquema.aula.Aula;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbEsquema")
public class Esquema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_esquema")
	private Integer id;
	
	@Column(name = "nome_esquema")
	private String nome;
	
	@OneToMany
	@JoinColumn(name = "id_esquema", referencedColumnName = "id_esquema")
	private List<Aula> aulas;

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

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
}
