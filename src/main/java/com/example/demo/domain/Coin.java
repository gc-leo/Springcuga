package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Document
public class Coin extends ResourceSupport {

    @Id
    @JsonProperty("id")
    private String idCoin;
    private String name;
    private String criptoname;
    @DBRef
    private List<Cpoi> id_cpois;
}
