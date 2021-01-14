package it.unical.asd.group6.computerSparePartsCompany.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public abstract class UserPrincipal implements UserDetails {

    @Override
    public abstract Collection<? extends GrantedAuthority> getAuthorities();

    public abstract String getPassword();

    public abstract String getUsername();

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
