package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Credentials {

    @Id
    public String id_credentials;

    public String provider;
    public String principal;
    public String secret;

    public Credentials(){}

    public Credentials(String id_credentials, String provider, String principal, String secret) {
        this.id_credentials = id_credentials;
        this.provider = provider;
        this.principal = principal;
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "id_credentials='" + id_credentials + '\'' +
                ", provider='" + provider + '\'' +
                ", principal='" + principal + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
