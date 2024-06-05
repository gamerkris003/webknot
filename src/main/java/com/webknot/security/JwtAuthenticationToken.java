package com.webknot.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final UserDetails principal;
    private String credentials;

    public JwtAuthenticationToken(UserDetails principal, String credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(true); // Set the authentication state
    }

    @Override
    public String getCredentials() {
        return credentials;
    }

    @Override
    public UserDetails getPrincipal() {
        return principal;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        credentials = null;
    }
}
