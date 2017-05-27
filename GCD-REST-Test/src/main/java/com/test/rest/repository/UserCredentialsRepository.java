package com.test.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.rest.model.UserCredential;

/**
 * The Interface UserCredentialsRepository. Expose all operations related to User Credentials
 */
@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredential, Long> {
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the user credential
	 */
	UserCredential findByUsername(String username);
}
