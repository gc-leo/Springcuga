package com.example.demo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Contact {

    @Id
    public String id;
    public ContactType type;
    public String value;
    public Boolean is_default;

}
