package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//TODO: Finish creating controller/domain/repo for Admin,Member..

@Getter
@Setter
@Document(collection = "admins")
public class Admin {
    @Id
    public String id_admin;
    public String email;
    public Profile profile;

    public Admin(){}

    //for testing with Seeds
    public Admin(String email) {
        this.email = email;
    }

    public Admin(String email, Profile profile) {
        this.email = email;
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id_admin='" + id_admin + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                '}';
    }
}
