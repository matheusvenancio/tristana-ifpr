package ifpr.esquema.perido;

public enum Periodo {

	MATUTINO("Matutino"),
	VESPERTINO("Vespertino"),
	NOTURNO("Noturno");
	
	private String label;
	
	private Periodo(String label){
		this.label = label;
	}

	public String getLabel(){
		return this.label;
	}
}
