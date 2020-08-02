package entities;

import java.util.ArrayList;

public class CompteRenumere extends Compte {

	private double tauxInteret;

	// defaultconstructor
	public CompteRenumere() {

	}

	public CompteRenumere(ArrayList<Client> clients, Employe employe, double TI) {
		super(clients, employe);
		this.tauxInteret = TI;
	}

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	private void calculerInteret() {

	}

	void verserInteret() {

	}

	@Override
	public String toString() {
		String clientsIds = null;
		for (Client cl : this.getClients()) {
			clientsIds += cl.getPersonid() + " , ";
		}

		return "Informations:\n*Account Type : 'Compte Renumere' \n*Account Id :  " + this.getCompteid()
				+ "\n*Account Clients ids :  " + clientsIds + "\n*Account responsible Employee's id :  "
				+ this.getEmploye().getPersonid() + "\n*Account responsible Agency id :  "
				+ this.getAgence().getNumero() + "\nAccount Interest Rate :  " + this.tauxInteret;
	}

}
