package com.example.demo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document
public class Cpoi {

    @Id
    public String id;
    public String name;
    public Location location;
    public Address address;
    public String description;
    public byte[] image;
    public String working_hours;

}
