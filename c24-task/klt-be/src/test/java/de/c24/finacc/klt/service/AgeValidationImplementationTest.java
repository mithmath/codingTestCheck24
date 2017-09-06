package de.c24.finacc.klt.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.c24.finacc.klt.service.AgeValidationImplementation;

public class AgeValidationImplementationTest {
	
	AgeValidationImplementation ageValidationImplementation = new AgeValidationImplementation();
	
	@Test
	public void shouldReturnYoungAge(){
		assertEquals(ageValidationImplementation.getValidateTheAge(10),"too young");
	}

	@Test
	public void shouldReturnOldgAge(){
		assertEquals(ageValidationImplementation.getValidateTheAge(90),"too old");
	}
	
	@Test
	public void shouldReturnMiddlegAge(){
		assertEquals(ageValidationImplementation.getValidateTheAge(45),"OK");
	}
}
