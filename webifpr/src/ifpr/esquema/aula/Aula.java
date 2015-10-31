package ifpr.esquema.aula;

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
@Table(name = "tbAula")
public class Aula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aula")
	private Integer id;

	@Column(name = "hora_aula")
	@Temporal(TemporalType.TIME)
	private Date hora;

	@Column(name = "dia_aula")
	private String dia;

	@Column(name = "periodo_aula")
	private String perido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getPerido() {
		return perido;
	}

	public void setPerido(String perido) {
		this.perido = perido;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

}
