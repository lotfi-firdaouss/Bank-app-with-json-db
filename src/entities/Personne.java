package entities;

import java.io.Serializable;

public abstract class Personne implements Serializable{
	private String nom;
	private String prenom;
	private static int i=0;
	private int Personid;
	
	//default constructor
	public Personne() {
	}
	
	//constructor
	public Personne(String nom,String prenom) {
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public static int getI() {
		return i;
	}
	public static void setI(int i) {
		Personne.i = i;
	}
	public int getPersonid() {
		return this.Personid;
	}
	public void setPersonid(int personid) {
		this.Personid=personid;
	}
}
