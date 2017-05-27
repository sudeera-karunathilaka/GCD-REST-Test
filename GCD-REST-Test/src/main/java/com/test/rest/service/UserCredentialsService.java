package com.test.rest.service;

import com.test.rest.model.UserCredential;

/**
 * The Interface UserCredentialsService.All user credentials related operations
 * expose as services are defined here
 */
public interface UserCredentialsService {
	
	/**
	 * Save.
	 *
	 * @param credential the credential
	 * @return the user credential
	 */
	UserCredential save(UserCredential credential);

	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the user credential
	 */
	UserCredential findByUsername(String username);
}
