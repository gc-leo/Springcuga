package com.example.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Coin {

    @Id
    public String id;
    public String name;
    public String criptoname;

    //represents coin value in dollars $$$
    public double dollarValue;

    //THX LOMBOK
    public Coin(String id, String name, String criptoname) {
        this.id = id;
        this.name = name;
        this.criptoname = criptoname;
    }


    public Coin(String name, String criptoname) {
        this.name = name;
        this.criptoname = criptoname;
    }
}
