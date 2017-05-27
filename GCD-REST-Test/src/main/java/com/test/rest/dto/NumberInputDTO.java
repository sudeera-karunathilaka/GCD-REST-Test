package com.test.rest.dto;

import javax.validation.constraints.NotNull;

/**
 * The Class NumberInputDTO. Act as payload for the Number API push method
 */
public class NumberInputDTO {

	/** The number one. */
	@NotNull(message = "Number One Cannot be null")
	private Integer numberOne;

	/** The number two. */
	@NotNull(message = "Number Two Cannot be null")
	private Integer numberTwo;

	/**
	 * Gets the number one.
	 *
	 * @return the number one
	 */
	public Integer getNumberOne() {
		return numberOne;
	}

	/**
	 * Sets the number one.
	 *
	 * @param numberOne the new number one
	 */
	public void setNumberOne(Integer numberOne) {
		this.numberOne = numberOne;
	}

	/**
	 * Gets the number two.
	 *
	 * @return the number two
	 */
	public Integer getNumberTwo() {
		return numberTwo;
	}

	/**
	 * Sets the number two.
	 *
	 * @param numberTwo the new number two
	 */
	public void setNumberTwo(Integer numberTwo) {
		this.numberTwo = numberTwo;
	}

}
