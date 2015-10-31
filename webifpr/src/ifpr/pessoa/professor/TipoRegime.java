package ifpr.pessoa.professor;

public enum TipoRegime {

	EXCLUSIVO("Exclusivo"),
	VINTE_HORAS("20H"),
	QUARENTA_HORAS("40H");
	
	private String label;
	
	private TipoRegime(String label){
		this.label = label;
	}

	public String getLabel(){
		return this.label;
	}
}
