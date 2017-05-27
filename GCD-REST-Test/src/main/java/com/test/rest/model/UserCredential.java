package com.test.rest.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * The Class UserCredential.Domain model for User Credentials to deal with DB
 * layer
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) }, name = "UserCredential")
public class UserCredential implements Serializable {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The username. */
	@Column(unique = true)

	private String username;
	
	/** The password. */
	private String password;
	
	/** The user role. */
	private String userRole = "API_CONSUMER";

	/** The created at. */
	@Column(name = "created_at")
	@CreatedDate
	private Calendar createdAt;

	/** The updated at. */
	@Column(name = "updated_at")
	@LastModifiedDate
	private Calendar updatedAt;

	/**
	 * Instantiates a new user credential.
	 */
	public UserCredential() {
		super();
	}

	/**
	 * Instantiates a new user credential.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public UserCredential(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRole the new user role
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
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
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets the updated at.
	 *
	 * @return the updated at
	 */
	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Sets the updated at.
	 *
	 * @param updatedAt the new updated at
	 */
	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}
}
