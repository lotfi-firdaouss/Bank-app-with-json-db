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

import entities.Compte;
import entities.CompteCourant;
import entities.CompteRenumere;

public class AccountService {

	public void addAccount(Compte compte) {
		try {

			File file = new File("src/files/accounts.json");
			List<Compte> myAccounts = new ArrayList<>();
			myAccounts = getAccountsList(file);

			if (file.length() == 0) {
				Compte.setI(Compte.getI() + 1);
				compte.setCompteid(Compte.getI());
			} else {
				int max = 0;
				for (Compte acc : myAccounts) {
					if (acc.getCompteid() >= max) {
						max = acc.getCompteid();
					}
				}
				max++;
				compte.setCompteid(max);
			}
			myAccounts.add(compte);

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// to avoid the exception
			JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(file, myAccounts);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addAccount(CompteCourant compte) {
		try {

			File file = new File("src/files/ComptesCourants.json");
			List<CompteCourant> myAccounts = new ArrayList<>();
			myAccounts = getCompteCourantList(file);

			if (file.length() == 0) {
				Compte.setI(Compte.getI() + 1);
				compte.setCompteid(Compte.getI());
			} else {
				int max = 0;
				for (Compte acc : myAccounts) {
					if (acc.getCompteid() >= max) {
						max = acc.getCompteid();
					}
				}
				max++;
				compte.setCompteid(max);
			}
			myAccounts.add(compte);

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// to avoid the exception
			JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(file, myAccounts);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addAccount(CompteRenumere compte) {
		try {

			File file = new File("src/files/ComptesRenumeres.json");
			List<CompteRenumere> myAccounts = new ArrayList<>();
			myAccounts = getCompteRenumereList(file);

			if (file.length() == 0) {
				Compte.setI(Compte.getI() + 1);
				compte.setCompteid(Compte.getI());
			} else {
				int max = 0;
				for (Compte acc : myAccounts) {
					if (acc.getCompteid() >= max) {
						max = acc.getCompteid();
					}
				}
				max++;
				compte.setCompteid(max);
			}
			myAccounts.add(compte);

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// to avoid the exception
			JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(file, myAccounts);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void DeleteAccount(int AccountId, File file) throws IOException {
		try {
			// first get the list of elemenets
			List<Compte> myAccounts = new ArrayList<>();
			myAccounts = getAccountsList(file);

			// then delete the specified element
			Compte AccountToBeDeleted = new Compte();
			for (Compte acc : myAccounts) {
				if (AccountId == acc.getCompteid()) {
					AccountToBeDeleted = acc;
				}
			}
			myAccounts.remove(AccountToBeDeleted);

			// lastly send back the data to the file
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// to avoid the exception
			JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(file, myAccounts);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static ArrayList<Compte> getAccountsList(File file) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Compte>>() {
		});

		List<Compte> myAccounts = new ArrayList<>();
		if (file.length() != 0) {
			myAccounts = objectReader.readValue(file);
		}
		return (ArrayList<Compte>) myAccounts;
	}

	public static ArrayList<CompteRenumere> getCompteRenumereList(File file) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<CompteRenumere>>() {
		});

		List<CompteRenumere> myAccounts = new ArrayList<>();
		if (file.length() != 0) {
			myAccounts = objectReader.readValue(file);
		}
		return (ArrayList<CompteRenumere>) myAccounts;
	}

	public static ArrayList<CompteCourant> getCompteCourantList(File file) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<CompteCourant>>() {
		});

		List<CompteCourant> myAccounts = new ArrayList<>();
		if (file.length() != 0) {
			myAccounts = objectReader.readValue(file);
		}
		return (ArrayList<CompteCourant>) myAccounts;
	}

}
