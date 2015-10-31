package ifpr.pessoa.usuario.coordenador;

import ifpr.curso.Curso;
import ifpr.pessoa.usuario.Usuario;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbCoordenador")
public class Coordenador extends Usuario {

	@JoinColumn(name = "id_curso", referencedColumnName ="id_curso")
	@OneToOne(cascade = CascadeType.MERGE)
	private Curso curso;

	@Override
	public String toString() {
		return this.nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}