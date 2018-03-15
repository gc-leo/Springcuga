package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Coin {

    @Id
    public String id_coin;
    public String name;
    public String criptoname;

}
