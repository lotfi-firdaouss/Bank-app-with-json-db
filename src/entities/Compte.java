package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Compte implements Serializable {
	private static int i = 0;
	private int Compteid;
	// il faut mettre la liste de client qui possédent un compte particulier
	private ArrayList<Client> clients;
	// il faut ajouter l'employé responsable de ce compte
	private Employe employe;
	// il faut ajouter l'agence à laquelle appartient ce compte
	private Agence agence;

	// default constructor
	public Compte() {
	}

	// constructor
	public Compte(ArrayList<Client> clients, Employe employe) {
		this.setClients(clients);
		this.setEmploye(employe);
		this.setAgence(employe.getAgence());// pas besoin de recevoir agence en tant qu'argument
		// puisqu'on peut l'avoir à partir de la methode getAgence() d'employe
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		Compte.i = i;
	}

	public int getCompteid() {
		return Compteid;
	}

	public void setCompteid(int compteid) {
		Compteid = compteid;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}
}
