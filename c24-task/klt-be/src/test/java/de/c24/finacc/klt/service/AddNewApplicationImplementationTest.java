package de.c24.finacc.klt.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.c24.finacc.klt.model.RegistrationForm;
import de.c24.finacc.klt.repository.InMemoryRepositry;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class AddNewApplicationImplementationTest {

	@Tested
	AddNewApplicationImplementation addNewApplicationImplementation;
	
	@Injectable
	InMemoryRepositry inMemoryRepositry;
	
	@Test
	public void shouldAddNewApplcantsToRepository(){
		
		RegistrationForm form = new RegistrationForm("Mithun","Mathew",32);
		
		new Expectations() {
			{
				inMemoryRepositry.addNewApplicants(form);
			}
		};
		addNewApplicationImplementation.addNewApplicationToInMemory("Mithun","Mathew",32);
	}

}
