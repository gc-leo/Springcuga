package com.example.demo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document
public class Member {

    @Id
    private String id;
    private String name;
    private Date dob;
    private String avatar;
    private Contact contact;
    private Credentials credentials;
    @DBRef
    private List<Cpoi> id_cpois = new ArrayList<>();


}
