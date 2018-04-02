package com.example.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Contact {

    @Id
    public String id;
    public ContactType type;
    public String value;
    public Boolean is_default;

}
