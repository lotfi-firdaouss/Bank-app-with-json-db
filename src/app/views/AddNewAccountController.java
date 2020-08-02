package app.views;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.controlsfx.control.CheckComboBox;

import entities.Client;
import entities.CompteCourant;
import entities.CompteRenumere;
import entities.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.AccountService;
import services.ClientService;
import services.EmployeeService;

public class AddNewAccountController {

	// make list to initialize the combo/choice boxes
	final ObservableList<Integer> ClientsID = FXCollections.observableArrayList();
	ObservableList<Integer> EmployeesID = FXCollections.observableArrayList();
//	ObservableList<Integer> AgenciesID = FXCollections.observableArrayList();
	ObservableList<String> TypesOfAccounts = FXCollections.observableArrayList("Renumere", "Courant");

	ObservableList<Integer> mySelectedClientsIDs = FXCollections.observableArrayList();

	ObservableList<String> items = FXCollections.observableArrayList();
	// fields
	@FXML
	private ListView<String> list = new ListView<String>();

	@FXML
	private CheckComboBox AccountClients;

	@FXML
	private ChoiceBox AccountEmployee;

//	@FXML
//	private ChoiceBox AccountAgency;

	@FXML
	private ChoiceBox AccountType;

	@FXML
	private TextField AccountInterestRate;

	// buttons
	@FXML
	private Button cancelButton;

	// labelresponse
	@FXML
	private Label labelResponse;

	@FXML
	private Button showClientsInfo;

	// initialize method
	public void initialize() throws IOException {

		AccountEmployee.setValue(1);
//		AccountAgency.setValue(1);
		AccountType.setValue("Renumere");

		AccountType.setItems(TypesOfAccounts);

		// to fill the clients combo box we need to know the number of clients we have
		// in our clients.json file, we're gonna
		// Acheive that by reading the file and getting this information from it, the
		// same goes for employees.
		File file = new File("src/files/clients.json");
		ArrayList<Client> Clients = ClientService.getClientList(file);
//		int NumberOfClients = ClientService.getNumberClients(file);
//		for (int i = 0; i < NumberOfClients; i++) {
//			ClientsID.add(i + 1);
//		}
		for (Client cl : Clients) {
			ClientsID.add(cl.getPersonid());
		}
		// System.out.println(ClientsID);

		// AccountClients.setCheckModel((IndexedCheckModel) ClientsID);
		// final CheckComboBox<Integer> AccountClients = new CheckComboBox(ClientsID);
		AccountClients.getItems().addAll(ClientsID);
		// System.out.println(AccountClients.getCheckModel());

//		// and listen to the relevant events (e.g. when the selected indices or
//		// selected items change).
//		AccountClients.getCheckModel().getCheckedItems().addListener(new ListChangeListener() {
//			public void onChanged(ListChangeListener.Change c) {
//				ArrayList<Integer> mySelectedClientsIDs = (ArrayList<Integer>) AccountClients.getCheckModel()
//						.getCheckedItems();
//			}
//		});

		// now we'll under go the same procedure for the AccountEmployee choice box
		file = new File("src/files/employees.json");
		ArrayList<Employe> myEmployees = EmployeeService.getEmployeesList(file);
		for (Employe emp : myEmployees) {
			EmployeesID.add(emp.getPersonid());
		}
		AccountEmployee.setItems(EmployeesID);

//		// and same thing for Accountagency choicebox
//		file = new File("src/files/agencies.json");
//		ArrayList<Agence> myAgencies = AgencyService.getAgencyList(file);
//		for (Agence ag : myAgencies) {
//			AgenciesID.add(ag.getNumero());
//		}
//		AccountAgency.setItems(AgenciesID);

	}

	// handlers (of buttons)
	@FXML
	public void handleCancelButtonAction(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void handleAccountType_InterestRate() {
		if (AccountType.getValue() == "Courant") {
			AccountInterestRate.setDisable(true);// greyed out
		} else {
			AccountInterestRate.setDisable(false);// disable graying out
		}
	}

	public void showClientsInfo() throws IOException {
		File file = new File("src/files/clients.json");
		ArrayList<Client> Clients = new ArrayList<Client>();
		Clients = ClientService.getClientList(file);

		// storing their ids in the precreated list
		items.clear();
		for (Client cl : Clients) {
			items.add(cl.toString());
		}
		list.setItems(items);
	}

	public ObservableList<Integer> getSelectedClients() {
		ObservableList<Integer> mySelectedClientsIDs = AccountClients.getCheckModel().getCheckedItems();
		return mySelectedClientsIDs;
	}

	public void GetSelectedClients() {
		System.out.println(AccountClients.getCheckModel().getCheckedItems().listIterator());
	}

	@FXML
	public void AddAccount() throws IOException {
		// GetSelectedClients();
		mySelectedClientsIDs = getSelectedClients();

		// we should firstly check that all fields are full otherwise nothing will run
		// and the user will get an warning
		if (mySelectedClientsIDs.isEmpty() || AccountEmployee.getValue() == null || AccountType.getValue() == null
				|| (AccountType.getValue() == "Renumere" && AccountInterestRate.getText().isEmpty())) {
			labelResponse.setTextFill(Color.RED);
			labelResponse.setText("All fields are requirred !");
		} else {
			// the Clients array is all the clients that we have stored in the clients.json
			// file
			ArrayList<Client> Clients;
			File file = new File("src/files/clients.json");
			Clients = ClientService.getClientList(file);

			// while the myClients array is the list of clients that we're looking for
			ArrayList<Client> myClients = new ArrayList<Client>();
			// and mySelectedClientsIDs is simply the ids of the clients that the user
			// selected

			// now we need to associate each id to its correspondant client using the id
			// itself and the list of the bank clients stored
			// in the .json file
			for (Client cl : Clients) {
				for (int id : mySelectedClientsIDs) {
					if (id == cl.getPersonid()) {
						myClients.add(cl);
					}
				}
			}
			// System.out.println(myClients);

			Employe myEmployee = new Employe();
			file = new File("src/files/employees.json");
			ArrayList<Employe> myEmployees = EmployeeService.getEmployeesList(file);
			for (Employe emp : myEmployees) {
				if (emp.getPersonid() == (int) AccountEmployee.getValue()) {
					myEmployee = emp;
				}
			}

//			Agence myAgency;
//			file = new File("src/files/agencies.json");
//			ArrayList<Agence> myAgencies = AgencyService.getAgencyList(file);
//			for (Agence ag : myAgencies) {
//				if (ag.getNumero() == (int) AccountAgency.getValue()) {
//					myAgency = ag;
//				}
//			}

			// actually we don't need the agency object since we can get it based on the
			// employee
			// object (have just noticed after putting all the hard work in :( but it's
			// okey!! :) )

			double myInterestRate;

//			// now we should create the account(Compte) object based on wheter it's
//			// "renumure" or "Courant"
//			Compte myAccount;
//			if (AccountType.getValue() == "Courant") {
//				myAccount = new CompteCourant(myClients, myEmployee);
//			} else {
//				myInterestRate = Double.parseDouble(AccountInterestRate.getText());
//				myAccount = new CompteRenumere(myClients, myEmployee, myInterestRate);
//			}
//
//			// adding the account object to the accounts.json file
//			AccountService myService = new AccountService();
//			// System.out.println(myAccount.getClass());
//			myService.addAccount(myAccount);

			AccountService myService = new AccountService();
			if (AccountType.getValue() == "Courant") {
				file = new File("src/files/ComptesCourants.json");
				CompteCourant myAccount = new CompteCourant(myClients, myEmployee);
				myService.addAccount(myAccount);
			} else {
				file = new File("src/files/ComptesRenumeres.json");
				myInterestRate = Double.parseDouble(AccountInterestRate.getText());
				CompteRenumere myAccount = new CompteRenumere(myClients, myEmployee, myInterestRate);
				myService.addAccount(myAccount);
			}

			// comment of success to the user
			labelResponse.setTextFill(Color.GREEN);
			labelResponse.setText("Account Added successfully ! ");

			// reseting the values of fields
			AccountEmployee.setValue(1);
			AccountType.setValue("Renumere");
			AccountInterestRate.setText("");
			AccountClients.getCheckModel().clearChecks();

		}

	}

}
