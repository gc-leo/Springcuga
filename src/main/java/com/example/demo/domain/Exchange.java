package com.example.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Exchange {

//    @Id
//    public String baseCurrency;
//    public List<String> exchangeCurrencies;

//    @Field
    public double btc;
    public double eth;
    public double usd;
    public double eur;
    public double rsd;
}
