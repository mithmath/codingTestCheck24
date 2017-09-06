package de.c24.finacc.klt.service;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import de.c24.finacc.klt.model.RegistrationForm;
import de.c24.finacc.klt.repository.InMemoryRepositry;

@Service
public class AddNewApplicationImplementation implements AddNewApplication {

	/** The in memory repositry. */
	@Inject
	InMemoryRepositry inMemoryRepositry;

	private static final Logger LOGGER = LogManager.getLogger(AddNewApplicationImplementation.class);

	@Override
	public void addNewApplicationToInMemory(String lastName, String firstName,int age) {

		RegistrationForm newRegistartion = new RegistrationForm(lastName, firstName,age);
		inMemoryRepositry.addNewApplicants(newRegistartion);
		LOGGER.info(firstName + ": New Registartion Completed");
	}

}
