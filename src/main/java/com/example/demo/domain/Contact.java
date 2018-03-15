package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Contact {

    @Id
    public String id_contact;

    public ContactType type;
    public String value;
    public Boolean is_default;

}
