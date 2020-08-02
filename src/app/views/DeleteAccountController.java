package app.views;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.CheckComboBox;

import entities.Compte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.AccountService;

public class DeleteAccountController {
	// create an obervable list to initialize the field
	ObservableList<Integer> AccountsID = FXCollections.observableArrayList();

	// create a list to retreive elements enterred by user
	ObservableList<Integer> mySelectedAccountsIDs = FXCollections.observableArrayList();

	// creating our list view with informations on Accounts
	// ObservableList<String> items = FXCollections.observableArrayList("Single",
	// "Double", "Suite", "Family App");
	ObservableList<String> items = FXCollections.observableArrayList();

	// fields
	@FXML
	private ListView<String> list = new ListView<String>();

	@FXML
	private CheckComboBox AccountsIds;

	@FXML
	private Button cancelButton;

	@FXML
	private Label labelResponse;

	// methods
	@FXML
	public void initialize() throws IOException {
		// getting Account list from Accounts.json file
		File file = new File("src/files/accounts.json");
		ArrayList<Compte> Accounts = AccountService.getAccountsList(file);
		AccountsID = FXCollections.observableArrayList();
		// storing their ids in the precreated list
		for (Compte cl : Accounts) {
			// System.out.println(cl.getClass());
			AccountsID.add(cl.getCompteid());
		}
		// System.out.println(AccountsID);
		// finally initialyzing our checkcombobox list with the list of ids
		AccountsIds.getItems().addAll(AccountsID);

		// populate our list view
		// System.out.println(items);
		for (Compte cl : Accounts) {
//			System.out.println(cl.getClass());
//			if (cl instanceof CompteRenumere) {
//				System.out.println("********");
//				items.add(((CompteRenumere) cl).toString());
//			} else if (cl instanceof CompteCourant) {
//				System.out.println("############");
//				items.add(((CompteCourant) cl).toString());
//			}
			items.add(cl.toString());

		}
		// System.out.println(items);
		list.setItems(items);
	}

	public void reset() throws IOException {
		// getting Account list from Accounts.json file
		File file = new File("src/files/Accounts.json");
		List<Compte> Accounts = AccountService.getAccountsList(file);

		AccountsIds.getItems().clear();
		AccountsID = FXCollections.observableArrayList();
		// storing their ids in the precreated list
		for (Compte cl : Accounts) {
			AccountsID.add(cl.getCompteid());
		}
		AccountsIds.getItems().addAll(AccountsID);

		// populate our list view
		items.clear();
		for (Compte cl : Accounts) {
			items.add(cl.toString());
		}
		list.setItems(items);
	}

	public ObservableList<Integer> getSelectedAccounts() {
		ObservableList<Integer> mySelectedAccountsIDs = AccountsIds.getCheckModel().getCheckedItems();
		return mySelectedAccountsIDs;
	}

	@FXML
	public void handleCancelButtonAction(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void DeleteAccount() throws IOException {
		// get ids of Accounts to be deleted
		mySelectedAccountsIDs = getSelectedAccounts();
		if (mySelectedAccountsIDs.isEmpty()) {
			labelResponse.setTextFill(Color.RED);
			labelResponse.setText("All fields are requirred !");
		} else {
			AccountService myservice = new AccountService();
			for (int id : mySelectedAccountsIDs) {
				// myservice.DeleteAccount(id);
			}

			// comment of success to the user
			labelResponse.setTextFill(Color.GREEN);
			labelResponse.setText("Employee deleted successfully ! ");

			// reseting fields
			AccountsIds.getCheckModel().clearChecks();
			reset();
		}
	}
}
