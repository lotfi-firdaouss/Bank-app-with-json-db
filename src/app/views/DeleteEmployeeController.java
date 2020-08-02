package app.views;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.controlsfx.control.CheckComboBox;

import entities.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.EmployeeService;

public class DeleteEmployeeController {

	ObservableList<Integer> EmployeesID = FXCollections.observableArrayList();
	ObservableList<Integer> mySelectedEmployeesIDs = FXCollections.observableArrayList();
	ObservableList<String> items = FXCollections.observableArrayList();

	// fields
	@FXML
	private ListView<String> list = new ListView<String>();

	@FXML
	private CheckComboBox EmployeesIds;

	@FXML
	private Button cancelButton;

	@FXML
	private Label labelResponse;

	// methods
	public void initialize() throws IOException {
		// getting Employee list from Employees.json file
		File file = new File("src/files/employees.json");
		ArrayList<Employe> Employees = new ArrayList<Employe>();
		Employees = EmployeeService.getEmployeesList(file);
		EmployeesID = FXCollections.observableArrayList();
		// storing their ids in the precreated list
		for (Employe cl : Employees) {
			EmployeesID.add(cl.getPersonid());
		}
		// System.out.println(EmployeesID);
		// finally initialyzing our checkcombobox list with the list of ids
		EmployeesIds.getItems().addAll(EmployeesID);

		// populate our list view
		for (Employe emp : Employees) {
			items.add(emp.toString());
		}
		list.setItems(items);
	}

	public void reset() throws IOException {
		// getting Employee list from Employees.json file
		File file = new File("src/files/Employees.json");
		ArrayList<Employe> Employees = new ArrayList<Employe>();
		Employees = EmployeeService.getEmployeesList(file);

		EmployeesIds.getItems().clear();
		EmployeesID = FXCollections.observableArrayList();
		// storing their ids in the precreated list
		for (Employe cl : Employees) {
			EmployeesID.add(cl.getPersonid());
		}
		EmployeesIds.getItems().addAll(EmployeesID);

		// populate our list view
		items.clear();
		for (Employe emp : Employees) {
			items.add(emp.toString());
		}
		list.setItems(items);
	}

	public ObservableList<Integer> getSelectedEmployees() {
		ObservableList<Integer> mySelectedEmployeesIDs = EmployeesIds.getCheckModel().getCheckedItems();
		return mySelectedEmployeesIDs;
	}

	@FXML
	public void handleCancelButtonAction(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void DeleteEmployee() throws IOException {
		// get ids of Employees to be deleted
		mySelectedEmployeesIDs = getSelectedEmployees();
		if (mySelectedEmployeesIDs.isEmpty()) {
			labelResponse.setTextFill(Color.RED);
			labelResponse.setText("All fields are requirred !");
		} else {
			EmployeeService myservice = new EmployeeService();
			for (int id : mySelectedEmployeesIDs) {
				myservice.DeleteEmployee(id);
			}

			// comment of success to the user
			labelResponse.setTextFill(Color.GREEN);
			labelResponse.setText("Employee deleted successfully ! ");

			// reseting fields
			EmployeesIds.getCheckModel().clearChecks();
			reset();
		}
	}
}
