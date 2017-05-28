package com.test.rest.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * The Class Number. Domain model for Numbers to deal with DB layer
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class GCDNumber implements Serializable {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The number one. */
	private int numberOne;

	/** The number two. */
	private int numberTwo;

	/** The created at. */
	@Column(name = "created_at")
	@CreatedDate
	private Calendar createdAt;

	/**
	 * Instantiates a new number.
	 */
	public GCDNumber() {
		super();
	}

	/**
	 * Instantiates a new GCD number.
	 *
	 * @param numberOne
	 *            the number one
	 * @param numberTwo
	 *            the number two
	 */
	public GCDNumber(int numberOne, int numberTwo) {
		super();
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the number one.
	 *
	 * @return the number one
	 */
	public int getNumberOne() {
		return numberOne;
	}

	/**
	 * Sets the number one.
	 *
	 * @param numberOne
	 *            the new number one
	 */
	public void setNumberOne(int numberOne) {
		this.numberOne = numberOne;
	}

	/**
	 * Gets the number two.
	 *
	 * @return the number two
	 */
	public int getNumberTwo() {
		return numberTwo;
	}

	/**
	 * Sets the number two.
	 *
	 * @param numberTwo
	 *            the new number two
	 */
	public void setNumberTwo(int numberTwo) {
		this.numberTwo = numberTwo;
	}

	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public Calendar getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the created at.
	 *
	 * @param createdAt
	 *            the new created at
	 */
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

}
