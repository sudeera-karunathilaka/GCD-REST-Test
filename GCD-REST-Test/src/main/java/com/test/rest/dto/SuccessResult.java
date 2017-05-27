package com.test.rest.dto;

/**
 * The Class SuccessResult. Act as Success Result for API outputs
 */
public class SuccessResult extends Result {
	
	/** The data. */
	private Object data;

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
