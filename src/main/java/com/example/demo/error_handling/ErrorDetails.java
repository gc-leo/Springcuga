package com.example.demo.error_handling;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class ErrorDetails {

    private String title;
    private Integer status;
    private String detail;
    private Long timeStamp;
    private String developerMessage;
    private Map<String, List<ValidationError>> errors;

}
