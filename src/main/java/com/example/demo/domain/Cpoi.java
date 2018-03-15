package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Document
public class Cpoi {

    @Id
    public String id;
    public String name;
    public String location;
    public String address;
    public String description;
    public String image;
    public String working_hours;

}
