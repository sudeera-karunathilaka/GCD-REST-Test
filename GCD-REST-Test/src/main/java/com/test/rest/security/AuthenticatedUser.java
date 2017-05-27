package com.test.rest.security;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.test.rest.model.UserCredential;

/**
 * The Class AuthenticatedUser. Expose data object for authenticated user
 */
public class AuthenticatedUser implements Authentication {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The credential. */
	private UserCredential credential;
	
	/** The authenticated. */
	private boolean authenticated = true;

	/**
	 * Instantiates a new authenticated user.
	 *
	 * @param credential the credential
	 */
	AuthenticatedUser(UserCredential credential) {
		this.credential = credential;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(credential.getUserRole());
		Collection<GrantedAuthority> grantedAuthorities = new LinkedList<GrantedAuthority>();
		grantedAuthorities.add(grantedAuthority);
		return grantedAuthorities;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return credential.getPassword();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getDetails()
	 */
	@Override
	public Object getDetails() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getPrincipal()
	 */
	@Override
	public Object getPrincipal() {
		return credential.getUsername();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#isAuthenticated()
	 */
	@Override
	public boolean isAuthenticated() {
		return this.authenticated;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#setAuthenticated(boolean)
	 */
	@Override
	public void setAuthenticated(boolean b) throws IllegalArgumentException {
		this.authenticated = b;
	}

	/* (non-Javadoc)
	 * @see java.security.Principal#getName()
	 */
	@Override
	public String getName() {
		return credential.getUsername();
	}
}
