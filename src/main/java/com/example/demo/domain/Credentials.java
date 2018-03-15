package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
public class Credentials {

    @Id
    public String id;
    public String provider;
    public String principal;
    public String secret;

}
