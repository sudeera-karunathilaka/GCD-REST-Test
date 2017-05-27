package com.test.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.rest.model.UserCredential;
import com.test.rest.security.SecureUserDetails;
import com.test.rest.service.UserCredentialsService;

/**
 * The Class SecureUserDetailsService.
 */
@Service
public class SecureUserDetailsService implements UserDetailsService {

	/** The user credential service. */
	@Autowired
	private UserCredentialsService userCredentialService;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredential userCredential = userCredentialService.findByUsername(username);
		if (userCredential == null) {
			throw new UsernameNotFoundException(username);
		} else {
			UserDetails details = new SecureUserDetails(userCredential);
			return details;
		}
	}

}
