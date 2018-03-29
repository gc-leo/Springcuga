package com.example.demo.domain.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

//model for our JwtAuth that is extending UsernamePasswordAuthenticationToken default class
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;

    //this is where we are saving our token
    public JwtAuthenticationToken(String token){

//        super(principal, credentials);
        //i don't need to set principal and credentials here?!
        //probably cause Indian dude is trying to simplify things
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    //also i am overriding this and telling i dont need to get/set those
    @Override
    public Object getCredentials() {
//        return super.getCredentials();
        return null;

    }

    @Override
    public Object getPrincipal() {
//        return super.getPrincipal();
        return null;
    }

    //don't need this constructor
//    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
//        super(principal, credentials, authorities);
//    }
}
