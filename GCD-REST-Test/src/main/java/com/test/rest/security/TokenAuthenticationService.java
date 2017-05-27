package com.test.rest.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.test.rest.service.UserCredentialsService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * The Class TokenAuthenticationService. Manage All JWT token related things
 */
@Service
public class TokenAuthenticationService {

	/** The secret. */
	@Value("${jwt.secret}")
	private String secret;

	/** The token prefix. */
	@Value("${jwt.token.prefix}")
	private String tokenPrefix;

	/** The header string. */
	@Value("${jwt.header}")
	private String headerString;

	/** The user credentials service. */
	@Autowired
	private UserCredentialsService userCredentialsService;

	/**
	 * Adds the authentication.
	 *
	 * @param response the response
	 * @param username the username
	 */
	public void addAuthentication(HttpServletResponse response, String username) {
		response.addHeader(headerString, tokenPrefix + " " + generateToken(username));
	}

	/**
	 * Generate token.
	 *
	 * @param username the username
	 * @return the string
	 */
	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	/**
	 * Gets the authentication.
	 *
	 * @param request the request
	 * @return the authentication
	 */
	public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(headerString);
		if (token != null) {
			String username;
			try {
				username = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();

				if (username != null) {
					return new AuthenticatedUser(userCredentialsService.findByUsername(username));
				}

			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
}