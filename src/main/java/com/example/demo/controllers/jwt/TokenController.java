package com.example.demo.controllers.jwt;

import com.example.demo.domain.jwt.JwtUser;
import com.example.demo.security.JwtGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {


    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    //they hit /token and give username ,id ,and role and get token where they can use other routes, Hello Route for example
    //those that are specified in @Configuration !!!   .authorizeRequests().antMatchers("/") !!!
    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser) {
        //why would i pass role also? hmmm???

        return jwtGenerator.generate(jwtUser);

    }
}