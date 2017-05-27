package com.test.rest.dto;

import com.test.rest.model.GCDNumber;

/**
 * The Class NumberOutputDTO.Act as response data for the Number API list method
 */
public class NumberOutputDTO {
	
	/** The order. */
	private long order;
	
	private GCDNumber gcdNumber;

	/**
	 * Instantiates a new number output DTO.
	 */
	public NumberOutputDTO() {
		super();
	}

	/**
	 * Instantiates a new number output DTO.
	 *
	 * @param order the order
	 * @param gcdNumber the value
	 */
	public NumberOutputDTO(long order, GCDNumber gcdNumber) {
		super();
		this.order = order;
		this.gcdNumber = gcdNumber;
	}

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public long getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(long order) {
		this.order = order;
	}

	public GCDNumber getGcdNumber() {
		return gcdNumber;
	}

	public void setGcdNumber(GCDNumber gcdNumber) {
		this.gcdNumber = gcdNumber;
	}

}