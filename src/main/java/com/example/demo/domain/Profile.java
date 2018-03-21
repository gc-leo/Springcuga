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
    private String id;
    @Size(min = 1, max = 20)
    private String name;
    @Size(min = 1, max = 20)
    private String given_name;
    @Size(min = 1, max = 20)
    private String family_name;
    @URL(message = "{URL.admin.profile.link}")
    private String link;
    private String picture;
    private String gender;
    private String locale;

}
