package com.example.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Document
public class Admin {

    @Id
    public String id;
    public String email;
    public Profile profile;


}
