package com.test.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.test.rest.security.ApiAuthenticationFilter;
import com.test.rest.security.TokenAuthenticationService;
import com.test.rest.service.impl.SecureUserDetailsService;

/**
 * The Class ApiSecurityConfig. Spring security configurations
 */
@Configuration
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

	/** The token authentication service. */
	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;

	/** The secure user details service. */
	@Autowired
	private SecureUserDetailsService secureUserDetailsService;

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().cacheControl();
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/api/register").permitAll().anyRequest()
				.authenticated().and().addFilterBefore(new ApiAuthenticationFilter(tokenAuthenticationService),
						UsernamePasswordAuthenticationFilter.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(secureUserDetailsService);
	}

}