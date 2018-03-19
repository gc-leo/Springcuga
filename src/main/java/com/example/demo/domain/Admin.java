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
    public String id;
    @Email(message = "Invalid email.Please correct it.")
    public String email;
    @Valid
    public Profile profile;
    @DBRef
    private List<Cpoi> id_cpois;

}
