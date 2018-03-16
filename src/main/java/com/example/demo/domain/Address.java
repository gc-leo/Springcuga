package com.example.demo.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    private String line1;
    private String line2;
    private String street;
    private String city;
    private String state;


}
