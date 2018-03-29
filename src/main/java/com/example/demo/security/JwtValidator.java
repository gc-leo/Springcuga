package com.example.demo.security;

import com.example.demo.domain.jwt.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JwtValidator {
//    @Value("${weather.api.api_key}")
//    private String secret;
    private String secret = "youtube";

    public JwtUser validate(String token){

//          payload example
//        {
//            "sub": "1234567890",
//                "name": "John Doe",
//                "iat": 1516239022
//        }

        JwtUser jwtUser = null;
        try{
            //using io.jsonwebtoken dependency here for handling jwt parsing!
            Claims body = Jwts.parser()
                    //ofc dude that created and dude that parses knows secret
                    .setSigningKey(secret)
                    .parseClaimsJws(token)

                    //standard JWT we got Header,Payload, and verify signature. we need Payload ofc which is body
                    .getBody();

            //parameters for our JwtUser model
            jwtUser = new JwtUser();
            jwtUser.setUsername(body.getSubject());
            jwtUser.setId((String) body.get("userId"));
            jwtUser.setRole((String) body.get("role"));
        }catch(Exception e){
            System.out.println(e);
        }

        return jwtUser;
    }
}
