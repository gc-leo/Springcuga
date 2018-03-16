package com.example.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document
public class Admin {

    @Id
    public String id;
    @Email(message = "Invalid email")
    public String email;
    public Profile profile;

}
