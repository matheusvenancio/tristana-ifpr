package ifpr.turma;

import ifpr.curso.Curso;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbTurma")
public class Turma{

	@Column(name = "id_turma")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_turma")
	private String nome; 
	
	@Column(name = "email_turma")
	private String email;
	
	@Column(name = "ano_criacao_turma")
	private Integer criacao;

	@Column(name = "ano_turma")
	private Integer ano; 
	
	@JoinColumn(name="id_curso", referencedColumnName="id_curso")
	@ManyToOne(fetch=FetchType.EAGER)
	private Curso curso;

	public Turma(){
		criacao = Calendar.getInstance().get(Calendar.YEAR);
		                                              
	}

	public Integer getId() {
		return id;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCriacao() {
		return criacao;
	}

	public void setCriacao(Integer criacao) {
		this.criacao = criacao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	@Override
	public String toString() {
		
		return this.nome;
	}
}
