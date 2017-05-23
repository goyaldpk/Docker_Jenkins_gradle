package com.andigital.andservice.read.api.domain;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aditeja on 5/23/2017.
 */
public class ANDRestServiceError {
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ANDRestServiceError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ANDRestServiceError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}
