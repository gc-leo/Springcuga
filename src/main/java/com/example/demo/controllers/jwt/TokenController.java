package com.example.demo.controllers.jwt;

import com.example.demo.domain.Member;
import com.example.demo.domain.jwt.JwtUser;
import com.example.demo.security.JwtGenerator;
import com.example.demo.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/token")
public class TokenController {

    private MemberService memberService;
    private JwtGenerator jwtGenerator;

    public TokenController(MemberService memberService, JwtGenerator jwtGenerator) {
        this.memberService = memberService;
        this.jwtGenerator = jwtGenerator;
    }

    //they hit /token and give username ,id ,and role and get token where they can use other routes, Hello Route for example
    //those that are specified in @Configuration !!!   .authorizeRequests().antMatchers("/") !!!
    @PostMapping
    public ResponseEntity<String> generate(@RequestBody final JwtUser jwtUser) {
        //why would i pass role also? hmmm???

        Member member = memberService.findMemberByNameAndPassword(jwtUser.getUsername(), jwtUser.getPassword());
        if (member == null) {
            System.out.println("Member doesn't exits with given username and password");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        System.out.println("Here's your token!");
        jwtUser.setRole(member.getCredentials().role);
        return new ResponseEntity<>(jwtGenerator.generate(jwtUser), HttpStatus.OK);
//            return jwtGenerator.generate(jwtUser);

    }
}