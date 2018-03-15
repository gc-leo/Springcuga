package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Document
public class Member {

    @Id
    public String id;
    public String name;
    public Date dob;
    public String avatar;
    public Contact contact;
    public Credentials credentials;


}
