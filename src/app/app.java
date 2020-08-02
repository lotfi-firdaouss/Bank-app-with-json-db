package app;

public class app {

	public static void main(String[] args) {
//		Agence ag=new Agence();
//		Employe employe1=new Employe("fifi","lotfi",ag);
//		Employe employe2=new Employe("kirinu-kun","Satochi",ag);
//		Employe employe3=new Employe("hh","bfhj",ag);
//		
////		employe1.afficher();
////		employe2.afficher();
////		employe3.afficher();
//		
//		Client client1=new Client("Leblanc","Math","France,parie,Résidence 23");
//		Client client2=new Client("Bond","James","USA,LA");
//		Client client3=new Client("nainai","Mehdi","Maroc,Rabat");

		// for the json library you need to write exactly the fields and the values each
		// time which can be an
		// exhausting and repetitive operation that's why I chose to use the jackson
		// library from the json library
		// that can transform an object to a string type then write it to the json file
		// which way better

		// working with jackson library

		try {
//			///openning a file
//			File file = new File("clients.json"); 
//			
//			/// create client object
//		    Client client = new Client(" Java", "bond", "casa");
//		    
//		    /// create object mapper instance
//		    ObjectMapper mapper = new ObjectMapper();
//		    
//		    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);//to avoid the exception
//
//		    String jsonStr = mapper.writeValueAsString(client); // convert client object to string for testing
//            System.out.println(jsonStr); //print the string value obtained
//            
//            ///associate the mapper object with the created file
//            JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));
//            
//            ///writing to the file
//		    mapper.writeValue(g, client); 
//		    mapper.writeValue(g, client2); 
//		    //the problem here is that each time we want to write to the file ,
//		    //it gets replaced with a new one , with the new given infomations
//		    
//            //mapper.writeValue(g, client3);

			// we'll try a new alternative which is getting the informations kept in the
			// "clients.json" as an array and then
			// manipulate the array(add values, modify ,delete or update as needed) then
			// transforming this array to a sting type
			// after that sending it again to the json file replacing the previous one =>
			// this represents a alternative solution
			// to our problem
			// now we should code this

//			///openning a file
//			File file = new File("clients.json"); 
//			
//			//create a new mapper object
//		    ObjectMapper objectMapper = new ObjectMapper();
//		    
//		    objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY); //to avoid the 
//		    //Can not deserialize instance of java.util.ArrayList out of VALUE_STRING exception
//		    
//		    //create an object reader to read from the file the objects of type Client
//		    ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Client>>(){}); 
//
//		    //define the list of objects Client that we'll get from the file
//		    List<Client> myObjects = objectReader.readValue(file);	    
//
//		    //test the myObjects list to see what it contains
//		    
//		    System.out.println(myObjects);
//		    for (Client cl : myObjects)
//		    {
//		    	System.out.print("Client :" );
//		    	cl.afficher();
//		    	System.out.println("*********************");
//		    }
			// ki kteb ghir client wa7ed, l9ay 7al

//
//		    mapper.writeValue(Paths.get("clients.json").toFile(), client);
//		    mapper.writeValue(Paths.get("clients.json").toFile(), client2);

			// I tought about a new solution which is creating a list object of objects
			// "Client" and then writing it to the file
			// so it will get easier to add elements to this list or delete elements from
			// it. Let's try !!

//			///openning a file
//			File file = new File("clients.json"); 
//			
//			/// create client object
//		    Client client = new Client(" Java", "bond", "casa");
//		    
//		    //create a list of client objects
//		    ArrayList<Client> myClients=new ArrayList<>();
//		    myClients.add(client);
//		    myClients.add(client1);
//		    myClients.add(client2);
//		    
//		    /// create object mapper instance
//		    ObjectMapper mapper = new ObjectMapper();
//		    
//		    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);//to avoid the exception
//
//		    String jsonStr = mapper.writeValueAsString(myClients); // convert myClients list object to string for testing
//            System.out.println(jsonStr); //print the string value obtained
//            
//            ///associate the mapper object with the created file
//            JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));
//            
//            //creating an object writer to change the parameters of the writing so that it write things
//            //ordered and simpler to read
//            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
//           
//            ///writing to the file
//            writer.writeValue(file, myClients);

//			//the writing to the "clients.json" went well, now let's try getting the informations and modifying it and
//			//sending it back to the file
//			
//			///openning a file
//			File file = new File("clients.json"); 
//			
//			//create a new mapper object
//		    ObjectMapper objectMapper = new ObjectMapper();
//		    
//		    objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY); //to avoid the 
//		    //Can not deserialize instance of java.util.ArrayList out of VALUE_STRING exception
//		    
//		    //create an object reader to read from the file the object of type list of Client
//		    ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Client>>(){}); 
//
//		    //first we create an empty list of Clients then if then we check if the file "clients.json" isn't empty
//		    //we fill this list with its components
//		    List<Client> myClients=new ArrayList<>();
//		    //define the list of objects Client that we'll get from the file
//		    if(file.length()!=0) {
//			    myClients = objectReader.readValue(file);		    	
//		    }
//	    
//
//		    //test the myObjects list to see what it contains
//		    
//		    System.out.println(myClients);
//		    
////		    for (Client cl : myObjects)
////		    {
////		    	System.out.print("Client :" );
////		    	cl.afficher();
////		    	System.out.println("*********************");
////		    }
//		    
//		    myClients.add(client3);
//		    myClients.add(client2);
//		    System.out.println(myClients);
//		    
//		    //now that the modifying works perfectly fine let's try resending the infomations back to the file
//		    
//		    /// create object mapper instance
//		    ObjectMapper mapper = new ObjectMapper();
//		    
//		    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);//to avoid the exception
//
//		    String jsonStr = mapper.writeValueAsString(myClients); // convert myClients list object to string for testing
//            System.out.println(jsonStr); //print the string value obtained
//            
//            ///associate the mapper object with the created file
//            JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));
//            
//            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
//         
//            ///writing to the file
//            writer.writeValue(file, myClients);

//			//testing the deleteClient from the clientservice
//			int id = 3;
//			ClientService service = new ClientService();
//			service.DeleteClient(3);

//			// testing the DeleteEmployee from the EmployeeService
//			int id = 4;
//			EmployeeService service = new EmployeeService();
//			service.DeleteEmployee(id);

//			// testing the DeleteAccount from the AccountService
//			int id = 2;
//			AccountService service = new AccountService();
//			service.DeleteAccount(id);

//			Compte compte = new CompteCourant();
//			System.out.println(compte.getClass());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
