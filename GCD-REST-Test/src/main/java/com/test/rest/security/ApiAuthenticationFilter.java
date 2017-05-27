package com.test.rest.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 * The Class ApiAuthenticationFilter. Filter for authenticate all incoming
 * requests
 */
public class ApiAuthenticationFilter extends GenericFilterBean {

	/** The token authentication service. */
	private TokenAuthenticationService tokenAuthenticationService;

	/**
	 * Instantiates a new api authentication filter.
	 *
	 * @param _tokenAuthenticationService the token authentication service
	 */
	public ApiAuthenticationFilter(TokenAuthenticationService _tokenAuthenticationService) {
		super();
		this.tokenAuthenticationService = _tokenAuthenticationService;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		Authentication authentication = tokenAuthenticationService.getAuthentication((HttpServletRequest) request);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
	}
}
