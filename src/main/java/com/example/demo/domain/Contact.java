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
    private String id;
    private ContactType type;
    private String value;
    private Boolean is_default;

}
