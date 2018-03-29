package com.example.demo.config;


import com.example.demo.security.JwtAuthenticationEntryPoint;
import com.example.demo.security.JwtAuthenticationProvider;
import com.example.demo.security.JwtAuthenticationTokenFilter;
import com.example.demo.security.JwtSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

//Determines if Spring Security's pre post annotations should be enabled.
//true if pre post annotations should be enabled false otherwise.
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    //idk why it wont wire Fking Bean here!

    //idk why it wont wire Fking Bean here!

    public JwtSecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }

//    public JwtSecurityConfig(boolean disableDefaults, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAuthenticationProvider jwtAuthenticationProvider) {
//        super(disableDefaults);
//        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
//        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
//    }

    //get AuthenticationProvider
    @Bean
    public AuthenticationManager authenticationManager() {
        //our custom AuthenticationProvider
        return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider));
    }


    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {

        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        //setting authenticationManager to filter
        filter.setAuthenticationManager(authenticationManager());
        //setting success handler to filter
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        System.out.println(filter);

        //we are returning filter where?
        //we are passing it in configure -> http.addFilterBefore(jwtAuthenticationTokenFilter(), arg2)
        return filter;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/**"); // #3
    }

    //config method that is providing security
    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http.
                    //disable cross site reference
                    // we don't need CSRF because our token is invulnerable
                csrf().disable()
                    //set entry point for error handling
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                    // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//                    //set routes we don't want authorisation on like login and other..
                .authorizeRequests()
                    .antMatchers("/rest/**").permitAll()
//                    .antMatchers("/coin/**").permitAll()
                    .anyRequest().authenticated();
//                .and()
//                    //routes we are authorizing
//                .authorizeRequests().antMatchers("/set/url/for/auth/**").authenticated();


                //.authorizeRequests()
                //.antMatchers("/set/url/for/auth/**").permitAll()
                //.anyRequest().authenticated();
        //why am i having this default class here? UsernamePasswordAuthenticationFilter
        //adding filter to http

        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }
}