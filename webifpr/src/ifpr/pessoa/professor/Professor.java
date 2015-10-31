package ifpr.pessoa.professor;

import java.util.List;

import ifpr.pessoa.Pessoa;
import ifpr.pessoa.professor.area.Area;
import ifpr.professorMateria.ProfessorMateria;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbProfessor")
public class Professor extends Pessoa {
	
	@Column(name="formacao_professor")
	private String formacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="titulacao_professor")
	private TipoTitulacao titulacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="regime_professor")
	private TipoRegime regime;

	@JoinColumn(name = "id_area", referencedColumnName ="id_area")
	@OneToOne(cascade = CascadeType.ALL)
	private Area aera;
	
	@OneToMany
	@JoinColumn(name = "id_professor", referencedColumnName = "id_pessoa")
	private List<ProfessorMateria> professorMateria;

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public TipoTitulacao getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(TipoTitulacao titulacao) {
		this.titulacao = titulacao;
	}

	public TipoRegime getRegime() {
		return regime;
	}

	public void setRegime(TipoRegime regime) {
		this.regime = regime;
	}

	public Area getAera() {
		return aera;
	}

	public void setAera(Area aera) {
		this.aera = aera;
	}

	public List<ProfessorMateria> getProfessorMateria() {
		return professorMateria;
	}

	public void setProfessorMateria(List<ProfessorMateria> professorMateria) {
		this.professorMateria = professorMateria;
	}
	
	@Override
	public String toString(){
		return this.nome;
	}
	
}
