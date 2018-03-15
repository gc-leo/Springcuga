package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "coins")
public class Coin {

    @Id
    public String id_coin;

    public String name;
    public String criptoname;

    public Coin(){}

    public Coin(String name, String criptoname) {
        this.name = name;
        this.criptoname = criptoname;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "id_coin='" + id_coin + '\'' +
                ", criptoname='" + criptoname + '\'' +
                '}';
    }
}
