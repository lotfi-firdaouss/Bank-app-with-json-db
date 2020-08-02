package app.views;

import java.io.IOException;

import app.Main;
import entities.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.ClientService;

public class AddNewClientController {
	
	Main main;
	
	@FXML
	private TextField ClientLastName;
	
	@FXML
	private TextField ClientFirstName;
	
	@FXML
	private TextField ClientAdress;
	
	@FXML
	public Button cancelButton;
	
	@FXML
	public Label labelResponse;

	
	@FXML
	private void AddClient() throws InterruptedException {
		if(ClientLastName.getText().isEmpty() || ClientFirstName.getText().isEmpty() || ClientAdress.getText().isEmpty()) {
			labelResponse.setTextFill(Color.RED);
			labelResponse.setText("All fields are requirred !");
		}else {
			String lastName=ClientLastName.getText();
			String firstName=ClientFirstName.getText();
			String adress=ClientAdress.getText();
			
			//create a client object and use the service to save it in my clients.json file
			Client myClient=new Client(lastName,firstName,adress);
			ClientService myservice=new ClientService();
			myservice.addClient(myClient);
			
			labelResponse.setTextFill(Color.GREEN);
			labelResponse.setText("Client Added successfully ! ");
			
			ClientLastName.setText("");
			ClientFirstName.setText("");
			ClientAdress.setText("");
			
		}
	}
	
	@FXML
	public void handleCancelButtonAction(ActionEvent event) {
	    Stage stage = (Stage) cancelButton.getScene().getWindow();
	    stage.close();
	}
}
