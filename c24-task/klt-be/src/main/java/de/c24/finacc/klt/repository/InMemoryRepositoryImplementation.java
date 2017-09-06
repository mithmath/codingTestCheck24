package de.c24.finacc.klt.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.c24.finacc.klt.model.RegistrationForm;


/**
 * The Class InMemoryRepositoryImplementation.
 */
@Repository
public class InMemoryRepositoryImplementation implements InMemoryRepositry{
	

	/** The cache memory. */
	List<RegistrationForm> cacheMemory = new ArrayList<>();
	
	/* (non-Javadoc)
	 * @see de.c24.finacc.klt.repository.InMemoryRepositry#addNewApplicants(de.c24.finacc.klt.model.RegistrationForm)
	 */
	@Override
	public void addNewApplicants(RegistrationForm newRegistartion){
		cacheMemory.add(newRegistartion);
	}
	
	/* (non-Javadoc)
	 * @see de.c24.finacc.klt.repository.InMemoryRepositry#getAllNewApplications()
	 */
	@Override
	public List<RegistrationForm> getAllNewApplications(){
		return cacheMemory;
	}

}
