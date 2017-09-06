package de.c24.finacc.klt.service;

import org.springframework.stereotype.Service;

/**
 * The Class AgeValidationImplementation.
 */
@Service
public class AgeValidationImplementation implements AgeValidation{
	
	/** The Constant YOUNG. */
	private static final String YOUNG = "too young";
	
	/** The Constant OLD. */
	private static final String OLD = "too old";
	
	/** The Constant OK. */
	private static final String OK = "OK";
	
	/* (non-Javadoc)
	 * @see de.c24.finacc.klt.service.AgeValidation#getValidateTheAge(int)
	 */
	@Override
	public String getValidateTheAge(int age){
		if(age < 18){
			return YOUNG;
		}else if(age > 67){
			return OLD;
		}
		return OK;
	}

}
