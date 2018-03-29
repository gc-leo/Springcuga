package com.example.demo.security;

import com.example.demo.domain.jwt.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public String generate(JwtUser jwtUser){

        //TODO: Look how to set expiration date on Token!
        //Jwts.builder().setExpiration() if you want to set expire on Token
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUsername());

        claims.put("userId", jwtUser.getId());
        claims.put("role", jwtUser.getRole());

        //signing key with secret key
        return Jwts.builder()
                .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512, "youtube")
                        .compact();

    }
}
