package com.andigital.andservice.read.api.domain;

/**
 * Created by aditeja on 5/23/2017.
 */
public class RestResponse {
    private Boolean success;
    private Object payload;
    private ErrorResponse error = new ErrorResponse();

    RestResponse(){};
    public RestResponse(Boolean success, Object payload, String message, Integer errorCode){
        this.success=success;
        this.payload=payload;
        this.error.setMessage(message);
        this.error.setErrorCode(errorCode);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}