package ifpr.pessoa.professor;

public enum TipoTitulacao {

	TECNLOGO("Tecnologo"),
	BACHALERADO("Bacharelado"),
	LICENCIATURA("Licenciatura"),
	ESPECIALIZACAO("Especialização"),
	MESTRADO("Mestrado"),
	DOUTORADO ("Doutorado");
	
	private String label;
	
	private TipoTitulacao(String label){
		this.label = label;
	}

	public String getLabel(){
		return this.label;
	}
}
