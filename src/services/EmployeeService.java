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
import entities.Employe;

public class EmployeeService {

	public void addEmployee(Employe employe) {
		try {

			File file = new File("src/files/employees.json");

			ArrayList<Employe> myEmployees = getEmployeesList(file);
//	    if(file.length()==0) {
//	    	Employe.setI(Compte.getI()+1);
//	    	employe.setPersonid(Employe.getI());
//	    }
//	    else{
//		    myEmployees = objectReader.readValue(file);
//		    int max=0;
//		    for(Employe emp : myEmployees) {
//		    	if(emp.getPersonid()>=max) {
//		    		max=emp.getPersonid();
//		    	}
//		    }
//		    max++;
//		    employe.setPersonid(max);
//	    }

			// we replaced the commented code with this function declared after this one
			Employe.setI(getNumberEmployees(file) + 1);
			employe.setPersonid(Client.getI());

			myEmployees.add(employe);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// to avoid the exception

			JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));

			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

			writer.writeValue(file, myEmployees);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void DeleteEmployee(int employeeId) {
		try {

			// first we get elements from the file
			File file = new File("src/files/employees.json");
			ArrayList<Employe> myEmployees = getEmployeesList(file);

			// here we delete the specified element
			Employe EmployeeToBeDeleted = new Employe();
			for (Employe emp : myEmployees) {
				if (employeeId == emp.getPersonid()) {
					EmployeeToBeDeleted = emp;
				}
			}
			myEmployees.remove(EmployeeToBeDeleted);

			// then we send the list back to the employees.json file
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// to avoid the exception
			JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(file, myEmployees);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static int getNumberEmployees(File file) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Employe>>() {
		});

		List<Employe> myEmployees = new ArrayList<>();
		if (file.length() == 0) {
			return 0;
		} else {
			myEmployees = objectReader.readValue(file);
			int max = 0;
			for (Employe emp : myEmployees) {
				if (emp.getPersonid() >= max) {
					max = emp.getPersonid();
				}
			}
			return max;
		}
	}

	public static ArrayList<Employe> getEmployeesList(File file) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Employe>>() {
		});

		ArrayList<Employe> myEmployees = new ArrayList<>();

		if (file.length() != 0) {
			myEmployees = objectReader.readValue(file);
		}

		return myEmployees;
	}
}
