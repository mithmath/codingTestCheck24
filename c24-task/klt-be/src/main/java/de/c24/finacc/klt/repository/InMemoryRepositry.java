package de.c24.finacc.klt.repository;

import java.util.List;

import de.c24.finacc.klt.model.RegistrationForm;

// TODO: Auto-generated Javadoc
/**
 * The Interface InMemoryRepositry.
 */
public interface InMemoryRepositry {
	
	/**
	 * Adds the new applicants.
	 *
	 * @param newRegistartion the new registartion
	 */
	public void addNewApplicants(RegistrationForm newRegistartion);
	
	/**
	 * Gets the all new applications.
	 *
	 * @return the all new applications
	 */
	public List<RegistrationForm> getAllNewApplications();

}
