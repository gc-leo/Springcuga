package com.example.demo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Profile {

    @Id
    public String id;
    @Size(min = 1, max = 20)
    public String name;
    @Size(min = 1, max = 20)
    public String given_name;
    @Size(min = 1, max = 20)
    public String family_name;
    @URL(message = "{URL.admin.profile.link}")
    public String link;
    public String picture;
    public String gender;
    public String locale;

}
