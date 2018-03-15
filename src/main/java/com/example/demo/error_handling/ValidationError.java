package com.example.demo.error_handling;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ValidationError {

    private String code;
    private String message;

}
