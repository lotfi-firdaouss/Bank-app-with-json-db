package services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import entities.Client;

public class ClientService {

	public void addClient(Client client) {
		try {

			File file = new File("src/files/clients.json");

			ObjectMapper objectMapper = new ObjectMapper();

			objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

			ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Client>>() {
			});

			List<Client> myClients = new ArrayList<>();
			if (file.length() != 0) {
				myClients = objectReader.readValue(file);
			}
//	    if(file.length()==0) {
//	    	Client.setI(Compte.getI()+1);
//	    	client.setPersonid(Client.getI());
//	    }
//	    else{
//		    myClients = objectReader.readValue(file);
//		    int max=0;
//		    for(Client cl : myClients) {
//		    	if(cl.getPersonid()>=max) {
//		    		max=cl.getPersonid();
//		    	}
//		    }
//		    max++;
//		    client.setPersonid(max);
//	    }

			// we replaced the commented code with this function declared after this one
			Client.setI(getNumberClients(file) + 1);
			client.setPersonid(Client.getI());

			myClients.add(client);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// to avoid the exception

			JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));

			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

			writer.writeValue(file, myClients);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void DeleteClient(int ClientID) {
		try {
			// get my list from the file
			File file = new File("src/files/clients.json");
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Client>>() {
			});

			List<Client> myClients = new ArrayList<>();
			if (file.length() != 0) {
				myClients = objectReader.readValue(file);
			}

			// delete the specified element
			Client ClientToBeDeleted = new Client();
			for (Client cl : myClients) {
				if (ClientID == cl.getPersonid()) {
					ClientToBeDeleted = cl;
				}
			}
			myClients.remove(ClientToBeDeleted);

			// resend the list to the file
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// to avoid the exception
			JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(file, myClients);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static int getNumberClients(File file) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Client>>() {
		});

		List<Client> myClients = new ArrayList<>();
		if (file.length() == 0) {
			return 0;
		} else {
			myClients = objectReader.readValue(file);
			int max = 0;
			for (Client cl : myClients) {
				if (cl.getPersonid() >= max) {
					max = cl.getPersonid();
				}
			}
			return max;
		}
	}

	public static ArrayList<Client> getClientList(File file) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Client>>() {
		});

		ArrayList<Client> myClients = new ArrayList<>();
		if (file.length() != 0) {
			myClients = objectReader.readValue(file);
		}

		return myClients;
	}
}
