package de.c24.finacc.klt.rest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.c24.finacc.klt.model.RegistrationForm;
import de.c24.finacc.klt.repository.InMemoryRepositry;
import de.c24.finacc.klt.service.AgeValidation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

/**
 * tests a little bit RestService
 * 
 * @author Jörn Schricker
 */
@RunWith(JMockit.class)
public class RestServiceTest {

	@Tested
	RestService restServiceTest;

	@Injectable
	AgeValidation ageValidation;

	@Injectable
	InMemoryRepositry inMemoryRepositry;

	/**
	 * testit
	 */
	@Test
	public void restTestit() {
		RestService restService = new RestService();
		Map<String, String> testMap = restService.getTestMap();
		assertEquals("suppe", testMap.get("fisch"));
	}

	@Test
	public void getAgeValidationTestwithTooYoungResult() {

		new Expectations() {
			{
				ageValidation.getValidateTheAge(10);
				returns("too young");
			}
		};
		assertEquals(restServiceTest.getAgeValidation(10), "too young");
	}

	@Test
	public void getAgeValidationTestwithOKResult() {

		new Expectations() {
			{
				ageValidation.getValidateTheAge(45);
				returns("OK");
			}
		};

		assertEquals(restServiceTest.getAgeValidation(45), "OK");

	}

	@Test
	public void getAgeValidationTestwithTooOldResult() {

		new Expectations() {
			{
				ageValidation.getValidateTheAge(90);
				returns("too old");
			}
		};

		assertEquals(restServiceTest.getAgeValidation(90), "too old");
	}

	@Test
	public void getAllAplicantsTest() throws JsonGenerationException, JsonMappingException, IOException {
		RegistrationForm newreg = new RegistrationForm("Mithun", "Mathew", 32);
		List<RegistrationForm> expectedResult = new ArrayList<>();
		ObjectMapper map = new ObjectMapper();
		expectedResult.add(newreg);
		String expec = map.writeValueAsString(expectedResult);
		new Expectations() {
			{
				inMemoryRepositry.getAllNewApplications();
				returns(expectedResult);
			}
		};

		assertEquals(restServiceTest.getAllApplicants(), expec);
	}
}
