package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Label {

    @Id
    public String id_label;

    public String name;
    public String category;

    public Label(){}

    public Label(String id_label, String name, String category) {
        this.id_label = id_label;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id_label='" + id_label + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
