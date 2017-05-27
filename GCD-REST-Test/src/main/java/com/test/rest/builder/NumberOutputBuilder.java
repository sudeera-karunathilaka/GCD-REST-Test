package com.test.rest.builder;

import com.test.rest.dto.NumberOutputDTO;
import com.test.rest.model.GCDNumber;

/**
 * The Class NumberOutputBuilder. Builds NumberOutputDTOs
 */
public class NumberOutputBuilder {
	
	/** The order. */
	private long order;
	private GCDNumber gcdNumber;
	

	/**
	 * Sets the order.
	 *
	 * @param order the order
	 * @return the number output builder
	 */
	public NumberOutputBuilder setOrder(long order) {
		this.order = order;
		return this;
	}

	/**
	 * Builds the.
	 *
	 * @return the number output DTO
	 */
	public NumberOutputDTO build() {
		return new NumberOutputDTO(order, gcdNumber);
	}

	public NumberOutputBuilder setValue(GCDNumber gcdNumber) {
		this.gcdNumber = gcdNumber;
		return this;
	}
}
