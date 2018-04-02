package com.example.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Credentials {

    @Id
    public String id;
    public String provider;
    public String principal;
    public String secret;
    public String role;
    public String password;

}
