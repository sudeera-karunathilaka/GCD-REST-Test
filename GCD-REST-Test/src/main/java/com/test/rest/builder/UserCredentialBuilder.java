package com.test.rest.builder;

import com.test.rest.model.UserCredential;

/**
 * The Class UserCredentialBuilder. Builds UserCredential Objects
 */
public class UserCredentialBuilder {
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;

	/**
	 * Sets the username.
	 *
	 * @param username the username
	 * @return the user credential builder
	 */
	public UserCredentialBuilder setUsername(String username) {
		this.username = username;
		return this;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password
	 * @return the user credential builder
	 */
	public UserCredentialBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Builds the.
	 *
	 * @return the user credential
	 */
	public UserCredential build() {
		return new UserCredential(username, password);
	}
}
