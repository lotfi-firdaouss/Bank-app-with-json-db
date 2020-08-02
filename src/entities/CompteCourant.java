package entities;

import java.util.ArrayList;

public class CompteCourant extends Compte {

	// default constructor
	public CompteCourant() {

	}

	public CompteCourant(Compte p) {
		super();
	}

	public CompteCourant(ArrayList<Client> clients, Employe employe) {
		super(clients, employe);
	}

	@Override
	public String toString() {
		String clientsIds = "";
		for (Client cl : this.getClients()) {
			clientsIds += cl.getPersonid() + " , ";
		}

		return "Informations:\n*Account Type : 'Compte Courant' \n*Account Id :  " + this.getCompteid()
				+ "\n*Account Clients ids :  " + clientsIds + "\n*Account responsible Employee's id :  "
				+ this.getEmploye().getPersonid() + "\n*Account responsible Agency id :  "
				+ this.getAgence().getNumero();
	}

}
