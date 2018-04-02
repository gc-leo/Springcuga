package com.example.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Builder
@Document
public class Member {

    @Id
    public String id;
    public String name;
    public Date dob;
    public String avatar;
    public Contact contact;
    public Credentials credentials;
    @DBRef
    private List<Cpoi> id_cpois;

}
