package com.example.demo.domain.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//Spring interface UserDetails!!
public class JwtUserDetails implements UserDetails {

    private String userName;
    private String token;
    private String id;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(String userName, String id, String token, List<GrantedAuthority> grantedAuthorities) {
        this.userName = userName;
        this.id = id;
        this.token = token;
        this.authorities = grantedAuthorities;
    }

    //overriding Spring Interface UserDetails!!!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
//        return false;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
