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

import entities.Agence;

public class AgencyService {

	public void addAgency(Agence agence) {
		try {

			File file = new File("src/files/agencies.json");

			ArrayList<Agence> myAgencies = getAgencyList(file);

			Agence.setI(getNumberAgencees(file) + 1);
			agence.setNumero(Agence.getI());

			myAgencies.add(agence);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// to avoid the exception

			JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));

			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

			writer.writeValue(file, myAgencies);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static int getNumberAgencees(File file) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Agence>>() {
		});

		List<Agence> myAgencies = new ArrayList<>();
		if (file.length() == 0) {
			return 0;
		} else {
			myAgencies = objectReader.readValue(file);
			int max = 0;
			for (Agence ag : myAgencies) {
				if (ag.getNumero() >= max) {
					max = ag.getNumero();
				}
			}
			return max;
		}
	}

	public static ArrayList<Agence> getAgencyList(File file) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Agence>>() {
		});

		ArrayList<Agence> myAgencies = new ArrayList<>();

		if (file.length() != 0) {
			myAgencies = objectReader.readValue(file);
		}

		return myAgencies;
	}

}
