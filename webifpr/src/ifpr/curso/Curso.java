package ifpr.curso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbCurso")
public class Curso {

	@Id
	@Column(name = "id_curso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_curso")
	private String nome; 
	
	@Column(name = "ementa_curso")
	private String ementa;
	
	@Column(name = "caminho_ementa_curso")
	private String caminhoEmenta;

	@Column(name = "duracao_curso")
	private Integer duracao;
	
	public Curso(){
	
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

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getCaminhoEmenta() {
		return caminhoEmenta;
	}

	public void setCaminhoEmenta(String caminhoEmenta) {
		this.caminhoEmenta = caminhoEmenta;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	
	@Override
	public String toString(){
		return this.nome;
	}
}
