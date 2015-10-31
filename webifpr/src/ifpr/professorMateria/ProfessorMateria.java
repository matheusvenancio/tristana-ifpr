package ifpr.professorMateria;

import ifpr.materia.Materia;
import ifpr.pessoa.Pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbProfessorMateria")
public class ProfessorMateria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_professor_mateiria")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_professor", referencedColumnName= "id_pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
	private Materia materia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}
