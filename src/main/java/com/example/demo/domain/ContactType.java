package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@ToString
public class ContactType {

    public String email;
    public String phone;
    public String address;

}
