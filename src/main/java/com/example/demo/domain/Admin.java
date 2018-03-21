package com.example.demo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document
public class Admin {

    @Id
    private String id;
    @Email(message = "Invalid email.Please correct it.")
    private String email;
    @Valid
    private Profile profile;
    @DBRef
    private List<Cpoi> id_cpois;

}
