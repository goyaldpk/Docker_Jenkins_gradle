package com.andigital.andservice.read.api;

/**
 * Created by aditeja on 5/23/2017.
 */
public class ANDRestServiceException extends Exception{
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
    public ANDRestServiceException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    public ANDRestServiceException() {
        super();
    }
}
