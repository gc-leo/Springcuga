package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Profile {
    @Id
    public String id;
    public String name;
    public String given_name;
    public String family_name;
    public String link;
    public String picture;
    public String gender;
    public String locale;

    public Profile() { }

    public Profile(String name, String given_name, String family_name, String link, String picture, String gender, String locale) {
        this.name = name;
        this.given_name = given_name;
        this.family_name = family_name;
        this.link = link;
        this.picture = picture;
        this.gender = gender;
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", given_name='" + given_name + '\'' +
                ", family_name='" + family_name + '\'' +
                ", link='" + link + '\'' +
                ", picture='" + picture + '\'' +
                ", gender='" + gender + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}
