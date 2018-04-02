package com.example.demo.domain.jwt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class JwtUser {

    private String id;
    private String username;
    private String password;
    private String role;

}
