package com.example.demo.error_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request) {

        ErrorDetails errorDetails = ErrorDetails.builder()
                .title("Resource not found exception")
                .timeStamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .detail(exception.getMessage())
                .developerMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity<>(errorDetails, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleResourceNotFoundException(MethodArgumentNotValidException exception, HttpServletRequest request) {

        ErrorDetails errorDetails = ErrorDetails.builder()
                .title("Validation Error")
                .timeStamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .detail("Input validation failed")
                .developerMessage(exception.getClass().getName())
                .errors(new HashMap<>())
                .build();

        for (FieldError fe : exception.getBindingResult().getFieldErrors()) {
            List<ValidationError> validationErrorList = errorDetails.getErrors().get(fe.getField());
            if (validationErrorList == null) {
                validationErrorList = new ArrayList<ValidationError>();
                errorDetails.getErrors().put(fe.getField(), validationErrorList);
            }
            ValidationError validationError = new ValidationError();
            validationError.setCode(fe.getCode());
            validationError.setMessage(fe.getDefaultMessage());
            validationErrorList.add(validationError);
        }


        return new ResponseEntity<>(errorDetails, null, HttpStatus.NOT_FOUND);
    }


}
