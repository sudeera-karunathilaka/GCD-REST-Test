package com.test.rest.security;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.rest.model.UserCredential;

/**
 * The Class SecureUserDetails. Expose secured user details for spring security
 */
public class SecureUserDetails implements UserDetails {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The user credential. */
	private UserCredential userCredential;

	/**
	 * Instantiates a new secure user details.
	 *
	 * @param userCredential the user credential
	 */
	public SecureUserDetails(UserCredential userCredential) {
		this.userCredential = userCredential;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userCredential.getUserRole());
		Collection<GrantedAuthority> grantedAuthorities = new LinkedList<GrantedAuthority>();
		grantedAuthorities.add(grantedAuthority);
		return grantedAuthorities;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return userCredential.getPassword();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return userCredential.getUsername();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
