package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "members")
public class Member {

    @Id
    public String id_member;

    public String name;
    //check if this is gona work in MongoDB- conversion to Date and other shananagance
    public Date dob;
    public String avatar;
    public Contact contact;
    public Credentials credentials;

    public Member(){}

    //for testing with Seeds
    public Member(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;

//        set current date automaticly in contructor
        Date date = new Date();
        this.dob = date;
    }

    public Member(String name, String avatar, Contact contact, Credentials credentials) {
        this.name = name;

        //set current date automaticly in contructor
        Date date = new Date();
        this.dob = date;

        this.avatar = avatar;
        this.contact = contact;
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id_member='" + id_member + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", avatar='" + avatar + '\'' +
                ", contact=" + contact +
                ", credentials=" + credentials +
                '}';
    }
}
