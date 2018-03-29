package com.example.demo.security;

import com.example.demo.domain.jwt.JwtAuthenticationToken;
import com.example.demo.domain.jwt.JwtUser;
import com.example.demo.domain.jwt.JwtUserDetails;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{

    private JwtValidator jwtValidator;

    public JwtAuthenticationProvider(JwtValidator jwtValidator) {
        this.jwtValidator = jwtValidator;
    }

    //don't need any additional Auth checks!
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        //we are casting usernamePasswordAuthenticationToken into our type of token
        //which doesn't have principal and credentials -> facepalm!
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;

        //we are getting string from our token cause that is what we need
        String token = jwtAuthenticationToken.getToken();

        //need to validate out token! an get decoded token
        JwtUser jwtUser = jwtValidator.validate(token);

        if( jwtUser == null){
            //i could make my own exception class
            throw new RuntimeException("JWT Token is incorrect kiddo");
        }

        //we are filling Spring base class grantedAuthorities with scopes our user can have
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());

        //we are filling our new model JwtUserDetails with stuff we want to pass
        //JwtUserDetails is implementing Spring interface UserDetails
        return new JwtUserDetails(jwtUser.getUsername(), jwtUser.getId(), token, grantedAuthorities);

        //Basic-ly we are passing required arguments here so Spring can validate them!

    }

    //is Jwt implementation of this particular class we are getting
    @Override
    public boolean supports(Class<?> aClass) {
        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
//        return false;
    }
}
