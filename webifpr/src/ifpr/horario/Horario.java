package ifpr.horario;

import ifpr.esquema.aula.Aula;
import ifpr.pessoa.professor.Professor;
import ifpr.sala.Sala;
import ifpr.turma.Turma;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbHorario")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_horario")
	private Integer id;

	@JoinColumn(name = "id_professor", referencedColumnName = "id_pessoa")
	@OneToOne(cascade = CascadeType.MERGE)
	private Professor professor;

	@JoinColumn(name = "id_turma", referencedColumnName = "id_turma")
	@OneToOne(cascade = CascadeType.MERGE)
	private Turma turma;

	@JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
	@OneToOne(cascade = CascadeType.MERGE)
	private Sala sala;

	@JoinColumn(name = "id_aula", referencedColumnName = "id_aula")
	@OneToOne(cascade = CascadeType.MERGE)
	private Aula aula;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

}
