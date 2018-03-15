package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
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


}
