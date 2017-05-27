package com.test.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.model.UserCredential;
import com.test.rest.repository.UserCredentialsRepository;
import com.test.rest.service.UserCredentialsService;

/**
 * The Class UserCredentialsServiceImpl.
 */
@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {

	/** The user credentials repository. */
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	/* (non-Javadoc)
	 * @see com.unico.services.UserCredentialsService#findByUsername(java.lang.String)
	 */
	@Override
	public UserCredential findByUsername(String username) {
		return userCredentialsRepository.findByUsername(username);
	}

	/* (non-Javadoc)
	 * @see com.unico.services.UserCredentialsService#save(com.unico.domain.UserCredential)
	 */
	@Override
	public UserCredential save(UserCredential credential) {
		return userCredentialsRepository.save(credential);
	}

}
