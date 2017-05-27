package com.test.rest.dto;

import java.util.List;

import org.springframework.validation.FieldError;

/**
 * The Class ErrorResult. Act as Error Result for API outputs
 */
public class ErrorResult extends Result {
	
	/** The field errors. */
	private List<FieldError> fieldErrors;

	/**
	 * Gets the field errors.
	 *
	 * @return the field errors
	 */
	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	/**
	 * Sets the field errors.
	 *
	 * @param fieldErrors the new field errors
	 */
	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
