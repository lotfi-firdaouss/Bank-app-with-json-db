package app;

import java.io.IOException;

public class MainApp {

	public static void main(String[] args) throws IOException {

//		try {
//			
//			
//		//*************** FIRST STEP ****************//////////////////////////////////////////////////////////
//		//openning the file , getting the informations in it and putting it into a list
//		
//		///openning the file already created in the files directory
//		File file = new File("src/files/clients.json"); 
//		
//		//create a new mapper object
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    
//	    objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY); //to avoid the 
//	    //Can not deserialize instance of java.util.ArrayList out of VALUE_STRING exception
//	    
//	    //create an object reader to read from the file the object of type list of Client
//	    ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Client>>(){}); 
//
//	    //first we create an empty list of Clients then if then we check if the file "clients.json" isn't empty
//	    //we fill this list with its components
//	    List<Client> myClients=new ArrayList<>();
//	    //define the list of objects Client that we'll get from the file
//	    if(file.length()!=0) {
//		    myClients = objectReader.readValue(file);		    	
//	    }
//	    ///////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	    
//	    //*************** SECOND STEP ****************////////////////////////////////////////////////////////
//	    //modifying the informations (adding , deleting , upadting...) by using a list
//	    //in this example we added some objects
//	    
//		Client client2=new Client("Bond","James","USA,LA");
//		Client client3=new Client("nainai","Mehdi","Maroc,Rabat");
//	    
//	    myClients.add(client3);
//	    myClients.add(client2);
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	    
//	    
//
//	    //*************** THIRD STEP ****************///////////////////////////////////////////////////////////
//	    //sending back the updated informations (the updated string) as an array to the file
//	    //threfore replacing the previous version of the array
//	    
//	    /// create object mapper instance
//	    ObjectMapper mapper = new ObjectMapper();
//	    
//	    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);//to avoid the exception
//        
//        ///associate the mapper object with the created file
//        JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));
//        
//        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
//     
//        ///writing to the file
//        writer.writeValue(file, myClients);
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////
//
//        
//		}catch (Exception ex) {
//		    ex.printStackTrace();
//		}
//      //now that it's working let's try and create some services that will do the job for us !!

//		//trying the addClient() fucntion from Services/ClientService.java
//		Client client=new Client("asmaaa","gerrar","Maroc");
//		ClientService service=new ClientService();
//		service.addClient(client);

//		//trying the addAccount() function from services/AccountService.java
//		//working with CompteCourant
//		
//		Client client2=new Client("Bond","James","USA,LA");
//		Client client3=new Client("nainai","Mehdi","Maroc,Rabat");
//		ArrayList<Client> clients=new ArrayList<>();
//		clients.add(client2);
//		clients.add(client3);
//		Agence ag=new Agence();
//		Employe employe2=new Employe("kirinu-kun","Satochi",ag);
//		
//		CompteCourant c1=new CompteCourant(clients,employe2);
//		AccountService service=new AccountService();
//		service.addAccount(c1);

//		//trying the addAccount() function from services/AccountService.java
//		//working with CompteRenumere
//				
//		Client client2=new Client("fifiiiiiiiii","James","USA,LA");
//		Client client3=new Client("zayneb","najiiiii","Maroc,Rabat");
//		ArrayList<Client> clients=new ArrayList<>();
//		clients.add(client2);
//		clients.add(client3);
//		Agence ag=new Agence();
//		Employe employe2=new Employe("ahmed","lmansouri",ag);
//		
//		CompteRenumere c1=new CompteRenumere(clients,employe2,0.05);
//		AccountService service=new AccountService();
//		service.addAccount(c1);
//		

//		//trying the addEmployee() function from services/EmployeeService.java
//		Agence ag=new Agence();
//		Employe employe=new Employe("fifi","lotfi",ag);
//		EmployeeService service=new EmployeeService();
//		service.addEmployee(employe);

	}

}
