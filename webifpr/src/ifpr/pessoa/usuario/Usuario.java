package ifpr.pessoa.usuario;

import ifpr.pessoa.Pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="tbUsuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends Pessoa {
	
	@Column(name="username")
	private String login;
	
	@Column(name="password")
	private String senha;
		
	@Column(name="authority")
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public boolean equals(Object other) {
		return other instanceof Usuario && (id != null) ?
				id.equals(((Usuario) other).getId()) :
					(other == this);
	}

	public int hashCode() {
		return id != null ? this.getClass().hashCode() +
				id.hashCode() : super
				.hashCode();
	}	
}
