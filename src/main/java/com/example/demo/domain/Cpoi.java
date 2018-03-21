package com.example.demo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document
public class Cpoi {

    @Id
    private String id;
    private String name;
    private Location location;
    private Address address;
    private String description;
    private byte[] image;
    private String working_hours;
    @DBRef
    private List<Coin> id_coins = new ArrayList<>();

}
