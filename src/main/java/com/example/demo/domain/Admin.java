package com.example.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Null;


@Getter
@Setter
@ToString
@Document
public class Admin {

    @Id
    @Null(message = "Id must be Null")
    public String id;
    @Email(message = "Invalid email")
    public String email;
    public Profile profile;


}
