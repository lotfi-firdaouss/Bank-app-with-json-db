package entities;

public class DirecteurGenerale extends Personne{

	private static int i=0;
	private int directid;
	private double revenu;
	//on doit aussi ajouter un champs de banque:
	private Banque banque;
	
	public DirecteurGenerale() {
		
	}

	public DirecteurGenerale(double revenu,Banque bq) {
		i++;
		this.directid=i;
		this.revenu=revenu;
		this.banque=bq;
	}
	
}
