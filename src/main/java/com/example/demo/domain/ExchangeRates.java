package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ExchangeRates {

    @Id
    @JsonIgnore
    public String id;
    //    @Field
    public double btc;
    public double eth;
    public double usd;
    public double eur;
    public double rsd;
}

