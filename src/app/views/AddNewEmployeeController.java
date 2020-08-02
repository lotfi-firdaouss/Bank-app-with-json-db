package app.views;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import entities.Agence;
import entities.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.AgencyService;
import services.EmployeeService;

public class AddNewEmployeeController {
	ObservableList<Integer> agenciesID = FXCollections.observableArrayList();
	File file = new File("src/files/agencies.json");

	// fields
	@FXML
	private TextField EmployeeLastName;

	@FXML
	private TextField EmployeeFirstName;

	@FXML
	private ChoiceBox EmployeeAgency;

	@FXML
	private DatePicker EmployeeHiringDate;

	// buttons
	@FXML
	public Button cancelButton;

	@FXML
	public Label labelResponse;

	// initialize method
	@FXML
	public void initialize() throws IOException {
		ArrayList<Agence> agencies = AgencyService.getAgencyList(file);
		for (Agence ag : agencies) {
			agenciesID.add(ag.getNumero());
		}
		EmployeeAgency.setValue(1);
		EmployeeAgency.setItems(agenciesID);
	}

	// handlers (of buttons)
	@FXML
	public void handleCancelButtonAction(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void AddEmployee() throws IOException {
		if (EmployeeLastName.getText().isEmpty() || EmployeeFirstName.getText().isEmpty()
				|| EmployeeAgency.getValue() == null || EmployeeHiringDate.getValue() == null) {
			labelResponse.setTextFill(Color.RED);
			labelResponse.setText("All fields are requirred !");
		} else {
			String lastName = EmployeeLastName.getText();
			String firstName = EmployeeFirstName.getText();

			// we try to get an agency among those already definned
			Agence agence = new Agence();
			ArrayList<Agence> agencies = AgencyService.getAgencyList(file);
			for (Agence ag : agencies) {
				if (ag.getNumero() == (int) EmployeeAgency.getValue()) {
					agence = ag;
				}
			}

			// to get the date we try to convert from the local date returned back by the
			// date picker of the fxml file
			ZoneId defaultZoneId = ZoneId.systemDefault();
			LocalDate localdate = EmployeeHiringDate.getValue();
			Date Hiringdate = Date.from(localdate.atStartOfDay(defaultZoneId).toInstant());

			// now we finally create an employee object to save in our employee.json file
			Employe myEmployee = new Employe(lastName, firstName, agence, Hiringdate);
			EmployeeService myService = new EmployeeService();
			myService.addEmployee(myEmployee);

			// comment to the user
			labelResponse.setTextFill(Color.GREEN);
			labelResponse.setText("Employee Added successfully ! ");

			// reseting the fields
			EmployeeFirstName.setText("");
			EmployeeLastName.setText("");
			EmployeeAgency.setValue(1);
			EmployeeHiringDate.setValue(null);

		}
	}

}
