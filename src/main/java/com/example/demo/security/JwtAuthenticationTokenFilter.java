package com.example.demo.security;

import com.example.demo.domain.jwt.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{


    //this filter is gonna get called for every url "/**"
    public JwtAuthenticationTokenFilter() {
        //set url i want to auth here **/rest/**
        super("/rest/**");
    }

    // we are handling auth here!!!!!!!!!
    // giving token and other stuff
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        //we are getting info here from Header
        String header = httpServletRequest.getHeader("Authorization");

        if(header == null || header.startsWith("Token")){
            throw new RuntimeException("JWT Token is missing");
        }

        String authenticationToken = header.substring(6);

        //this is our token we need to send
        //we should also set principal and and credentials here but we have overriden them with nulls
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);

        //we are getting AuthManager and then authenticating it using this particular token
        return getAuthenticationManager().authenticate(token);
    }

    //this is what we are doing if Auth Passes
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        //go to the next filter
        chain.doFilter(request, response);
        //we can implement more filters
    }
}
