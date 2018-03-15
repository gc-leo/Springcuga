package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "cpois")
public class Cpoi {
    @Id
    public String id_cpoi;

    public String name;
    public String location;
    public String address;
    public String description;
    public String image;
    public String working_hours;

    //Each Cpoi has its own set of labels?
    //public List<Label> labels;

    public Cpoi() {}

    public Cpoi(String name, String location, String address, String description, String image, String working_hours) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.description = description;
        this.image = image;
        this.working_hours = working_hours;
    }

    @Override
    public String toString() {
        return "Cpoi{" +
                "id_cpoi='" + id_cpoi + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", working_hours='" + working_hours + '\'' +
                '}';
    }
}
