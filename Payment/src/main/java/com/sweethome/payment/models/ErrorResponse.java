package com.sweethome.payment.models;

public class ErrorResponse {
    private String message;
    private Integer statusCode;

    public ErrorResponse(String message,Integer statusCode){
        this.message = message;
        this.statusCode = statusCode;
    }


    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
