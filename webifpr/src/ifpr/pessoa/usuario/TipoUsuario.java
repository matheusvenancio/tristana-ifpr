package ifpr.pessoa.usuario;

public enum TipoUsuario {
	
	ROLE_ADMIN("Administrador"),
	ROLE_USER("Usu�rio");
	
	private String label;
	
	private TipoUsuario(String label)
	{
		this.label = label;
	}

	public String getLabel()
	{
		return this.label;
	}
}
