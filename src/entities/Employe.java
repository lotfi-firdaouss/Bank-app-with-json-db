package entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Employe extends Personne implements Serializable {

	// private Date date=new Date(0,0,0); this method is deprecated so we use
	// instead:
	private Calendar calendar = Calendar.getInstance();
	// il faut aussi ajouter le champs d'agence danslaquelle l'object employé
	// travaille
	private Agence agence;

	// default constructor
	public Employe() {
		super();
	}

	// constructor
	public Employe(String nom, String prenom, Agence ag) {
		super(nom, prenom);
		this.calendar = Calendar.getInstance();
		this.agence = ag;
	}

	public Employe(String nom, String prenom, Agence ag, Date date) {
		super(nom, prenom);
		this.calendar = Calendar.getInstance();
		this.agence = ag;
		this.calendar.setTime(date);
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Agence getAgence() {
		return this.agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	boolean mutation() {
		boolean b = false;

		return b;
	}

	public void afficher() {
		System.out.println("Informations : \n*Nom : " + this.getNom() + "\n*Prenom : " + this.getPrenom()
				+ "\n*Agence : " + this.agence + "\n" + "*Id : " + this.getPersonid());
	}

	@Override
	public String toString() {
		return "Informations : \n*Nom : " + this.getNom() + "\n*Prenom : " + this.getPrenom() + "\n*Agence Id: "
				+ this.agence.getNumero() + "\n" + "*Employee Id : " + this.getPersonid()
				+ "\n--------------------------------------------------";
	}
}
