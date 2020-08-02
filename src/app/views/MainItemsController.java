package app.views;

import java.io.IOException;

import app.Main;
import javafx.fxml.FXML;

public class MainItemsController {

	private Main main;

	@FXML
	private void ClientAddBtn() throws IOException {
		main.showStageAddNewClient();
	}

	@FXML
	private void DeleteClientBtn() throws IOException {
		main.showStageDeleteClient();
	}

	@FXML
	private void EmployeeAddBtn() throws IOException {
		main.showStageAddNewEmployee();
	}

	@FXML
	private void DeleteEmployeeBtn() throws IOException {
		main.showStageDeleteEmployee();
	}

	@FXML
	private void AccountAddBtn() throws IOException {
		main.showStageAddNewAccount();
	}

	@FXML
	private void DeleteAccountBtn() throws IOException {
		main.showStageDeleteAccount();
	}

}
