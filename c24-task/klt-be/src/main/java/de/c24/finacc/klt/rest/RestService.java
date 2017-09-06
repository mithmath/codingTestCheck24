package de.c24.finacc.klt.rest;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import de.c24.finacc.klt.repository.InMemoryRepositry;
import de.c24.finacc.klt.service.AgeValidation;

/**
 * @author Jörn Schricker
 */
@Component
@Path("/")
public class RestService {

	@Inject
	AgeValidation ageValidation;
	
	@Inject
	InMemoryRepositry inMemoryRepositry;

	/**
	 * testmap
	 *
	 * @return map containing fisch and suppe
	 */
	@GET
	@Path("/testit")
	@Produces(APPLICATION_JSON_VALUE)
	public Map<String, String> getTestMap() {
		Map<String, String> returnMap = new HashMap<>();

		returnMap.put("fisch", "suppe");

		return returnMap;
	}

	/**
	 * Gets the age validation.
	 *
	 * @param age the age
	 * @return the age validation
	 */
	@GET
	@Path("/age/{age}")
	@Produces(ALL_VALUE)
	public String getAgeValidation(@PathParam("age") int age) {

		return ageValidation.getValidateTheAge(age);
	}
	
	/**
	 * Gets the all applicants.
	 *
	 * @return the all applicants
	 * @throws JsonGenerationException the json generation exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@GET
	@Path("/allApplications")
	@Produces(APPLICATION_JSON_VALUE)
	public String getAllApplicants() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(inMemoryRepositry.getAllNewApplications());
	}
}
