package com.test.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.builder.ResultBuilder;
import com.test.rest.builder.UserCredentialBuilder;
import com.test.rest.dto.Result;
import com.test.rest.dto.UserRegistrationDTO;
import com.test.rest.model.UserCredential;
import com.test.rest.security.TokenAuthenticationService;
import com.test.rest.service.UserCredentialsService;

/**
 * The Class UserRegistrationController. Expose user registration related API
 * methods
 */
@RestController
@RequestMapping("/api/register")
public class UserRegistrationController {

	/** The token authentication service. */
	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;

	/** The user credentials service. */
	@Autowired
	private UserCredentialsService userCredentialsService;

	/**
	 * Register.
	 *
	 * @param userRegistration
	 *            the user registration
	 * @return the result
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result register(@Validated @RequestBody UserRegistrationDTO userRegistration) {
		UserCredential credential = userCredentialsService.save(new UserCredentialBuilder()
				.setUsername(userRegistration.getUsername()).setPassword(userRegistration.getPassword()).build());
		return ResultBuilder.buildSuccessResult("", tokenAuthenticationService.generateToken(credential.getUsername()));
	}

}
