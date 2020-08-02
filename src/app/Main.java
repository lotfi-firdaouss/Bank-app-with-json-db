package app;

import java.io.IOException;
import java.util.ArrayList;

import entities.Agence;
import entities.Banque;
import entities.DirecteurGenerale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage; // we create a stage
	private static BorderPane root; // our root pane

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Application");

		// we call this method to show the main view
		showMainView();

		// we call this method to show the main items in our main view
		showMainItems();

		ArrayList<Agence> agences = new ArrayList<>();
		DirecteurGenerale dg = new DirecteurGenerale();
		Banque bank = new Banque("Maroc", 1000000, "Bank elmaghrib", dg, agences);
		Agence ag1 = new Agence("Maroc,Casa", "agence casa", bank);
		Agence ag2 = new Agence("Maroc,Fez", "agence fez", bank);
		Agence ag3 = new Agence("Maroc,Rabat", "agence rabat", bank);
		Agence ag4 = new Agence("Maroc,Berrechid", "agence berrechid", bank);
		Agence ag5 = new Agence("MAroc,Tanger", "agence tanger", bank);
		Agence ag6 = new Agence("Maroc,Eljadida", "agence eljadida", bank);
		Agence ag7 = new Agence("Maroc,Chaouen", "agence chaouen", bank);

//		//these lines of code are only executed one time to store needed informations(agencies of our bank) in the
//		//agencies.json file
//		AgencyService myservice=new AgencyService();
//		myservice.addAgency(ag1);
//		myservice.addAgency(ag2);
//		myservice.addAgency(ag3);
//		myservice.addAgency(ag4);
//		myservice.addAgency(ag5);
//		myservice.addAgency(ag6);
//		myservice.addAgency(ag7);

	}

	// now we need to create a function that loads the fxml document into our main
	// class
	public static void showMainView() throws IOException {
		// we start by creating a loader
		FXMLLoader loader = new FXMLLoader();
		// then we use it to load the fxml document
		loader.setLocation(Main.class.getResource("views/MainView.fxml"));
		// now we associate our fxml file with the root
		root = loader.load();
		// create a scene and put the root pane in it
		Scene primaryScene = new Scene(root, 700, 500);
		// We need to associate the root with the primary stage so that it shows
		primaryStage.setScene(primaryScene);
		// we call the show method to show our window at last
		primaryStage.show();
	}

	public static void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/MainItems.fxml"));
		BorderPane MainItems = loader.load();
		// now that we loaded our mainitems fxml file to a borderpane we need to add it
		// to the center of the main view
		root.setCenter(MainItems);
	}

	public static void showStageAddNewClient() throws IOException {
		// we should firstly load the accurate fxml file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/AddNewClient.fxml"));
		BorderPane AddClientPane = loader.load();

		// then we need to ceate a new stage, set the title, the owner and the modality
		Stage AddClientStage = new Stage();
		AddClientStage.setTitle("Add New Client");
		AddClientStage.initOwner(primaryStage);
		AddClientStage.initModality(Modality.WINDOW_MODAL);
		// create a scene and associate AddClientPane with it
		Scene AddClientScene = new Scene(AddClientPane);
		// associate the scene to the appropriate stage
		AddClientStage.setScene(AddClientScene);
		// finally show the stage
		AddClientStage.showAndWait();

	}

	public static void showStageAddNewEmployee() throws IOException {
		// we should firstly load the accurate fxml file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/AddNewEmployee.fxml"));
		BorderPane AddEmployeePane = loader.load();

		// then we need to ceate a new stage, set the title, the owner and the modality
		Stage AddEmployeeStage = new Stage();
		AddEmployeeStage.setTitle("Add New Employee");
		AddEmployeeStage.initOwner(primaryStage);
		AddEmployeeStage.initModality(Modality.WINDOW_MODAL);
		// create a scene and associate AddClientPane with it
		Scene AddClientScene = new Scene(AddEmployeePane);
		// associate the scene to the appropriate stage
		AddEmployeeStage.setScene(AddClientScene);
		// finally show the stage
		AddEmployeeStage.showAndWait();
	}

	public static void showStageAddNewAccount() throws IOException {
		// load the file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/AddNewAccount.fxml"));
		BorderPane AddAccountPane = loader.load();

		// create a new stage and associate the just created pane with it
		Stage AddAccountStage = new Stage();
		Scene AddAccountScene = new Scene(AddAccountPane);
		AddAccountStage.initOwner(primaryStage);
		AddAccountStage.initModality(Modality.WINDOW_MODAL);
		AddAccountStage.setScene(AddAccountScene);

		// finally show the scene in the stage and wait for it to close
		AddAccountStage.showAndWait();

	}

	public static void showStageDeleteClient() throws IOException {
		// load the file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/DeleteClient.fxml"));
		BorderPane AddAccountPane = loader.load();

		// create a new stage and associate the just created pane with it
		Stage DeleteClientStage = new Stage();
		Scene DeleteClientScene = new Scene(AddAccountPane);
		DeleteClientStage.initOwner(primaryStage);
		DeleteClientStage.initModality(Modality.WINDOW_MODAL);
		DeleteClientStage.setScene(DeleteClientScene);

		// finally show the scene in the stage and wait for it to close
		DeleteClientStage.showAndWait();
	}

	public static void showStageDeleteEmployee() throws IOException {
		// load the file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/DeleteEmployee.fxml"));
		BorderPane AddAccountPane = loader.load();

		// create a new stage and associate the just created pane with it
		Stage DeleteEmployeeStage = new Stage();
		Scene DeleteEmployeeScene = new Scene(AddAccountPane);
		DeleteEmployeeStage.initOwner(primaryStage);
		DeleteEmployeeStage.initModality(Modality.WINDOW_MODAL);
		DeleteEmployeeStage.setScene(DeleteEmployeeScene);

		// finally show the scene in the stage and wait for it to close
		DeleteEmployeeStage.showAndWait();
	}

	public static void showStageDeleteAccount() throws IOException {
		// load the file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/DeleteAccount.fxml"));
		BorderPane AddAccountPane = loader.load();

		// create a new stage and associate the just created pane with it
		Stage DeleteAccountStage = new Stage();
		Scene DeleteAccountScene = new Scene(AddAccountPane);
		DeleteAccountStage.initOwner(primaryStage);
		DeleteAccountStage.initModality(Modality.WINDOW_MODAL);
		DeleteAccountStage.setScene(DeleteAccountScene);

		// finally show the scene in the stage and wait for it to close
		DeleteAccountStage.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
