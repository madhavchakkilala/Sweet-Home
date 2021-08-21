package com.sweethome.payment.exception;

public class InvalidPaymentCredentialsException extends Exception{
    public InvalidPaymentCredentialsException(String message){
        super(message);
    }
}
