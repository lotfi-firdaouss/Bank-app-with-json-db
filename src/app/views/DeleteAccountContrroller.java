package app.views;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.controlsfx.control.CheckComboBox;

import entities.CompteCourant;
import entities.CompteRenumere;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.AccountService;

public class DeleteAccountContrroller {

	ObservableList<Integer> AccountsID = FXCollections.observableArrayList();
	ObservableList<Integer> mySelectedAccountsIDs = FXCollections.observableArrayList();
	String TypeAccount;

	ObservableList<String> items = FXCollections.observableArrayList();

	// fields
	@FXML
	private ListView<String> list = new ListView<String>();

	@FXML
	private RadioButton RadioCourant;

	@FXML
	private RadioButton RadioRenumere;

	@FXML
	private CheckComboBox AccountsIds;

	@FXML
	private Button cancelButton;

	@FXML
	private Label labelResponse;

	// methods
	public void initialize() throws IOException {

	}

	public void set() throws IOException {
		// Get type of account
		if (RadioCourant.isSelected()) {
			TypeAccount = "Courant";
			File file = new File("src/files/ComptesCourants.json");
			ArrayList<CompteCourant> Accounts = AccountService.getCompteCourantList(file);

			AccountsIds.getItems().clear();
			AccountsID = FXCollections.observableArrayList();
			for (CompteCourant cl : Accounts) {
				// System.out.println(cl.getClass());
				AccountsID.add(cl.getCompteid());
			}
			AccountsIds.getItems().addAll(AccountsID);

			items.clear();
			for (CompteCourant cl : Accounts) {
				items.add(cl.toString());
			}
			list.setItems(items);

		} else {
			TypeAccount = "Renumere";
			File file = new File("src/files/ComptesRenumeres.json");
			ArrayList<CompteRenumere> Accounts = AccountService.getCompteRenumereList(file);

			AccountsIds.getItems().clear();
			AccountsID = FXCollections.observableArrayList();
			for (CompteRenumere cl : Accounts) {
				// System.out.println(cl.getClass());
				AccountsID.add(cl.getCompteid());
			}
			AccountsIds.getItems().addAll(AccountsID);

			items.clear();
			for (CompteRenumere cl : Accounts) {
				items.add(cl.toString());
			}
			list.setItems(items);

		}
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
		if (mySelectedAccountsIDs.isEmpty() || TypeAccount.isEmpty()) {
			labelResponse.setTextFill(Color.RED);
			labelResponse.setText("All fields are requirred !");
		} else {
			AccountService myservice = new AccountService();
			if (TypeAccount == "Courant") {
				File file = new File("src/files/ComptesCourants.json");
				for (int id : mySelectedAccountsIDs) {
					myservice.DeleteAccount(id, file);
				}
			} else {
				File file = new File("src/files/ComptesRenumeres.json");
				for (int id : mySelectedAccountsIDs) {
					myservice.DeleteAccount(id, file);
				}
			}

			// comment of success to the user
			labelResponse.setTextFill(Color.GREEN);
			labelResponse.setText("Account deleted successfully ! ");

			// reseting fields
			AccountsIds.getCheckModel().clearChecks();
			// reset();
		}
	}

}
