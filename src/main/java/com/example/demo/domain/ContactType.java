package com.example.demo.domain;

import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class ContactType {

    public String email;
    public String phone;
    public String address;

}
