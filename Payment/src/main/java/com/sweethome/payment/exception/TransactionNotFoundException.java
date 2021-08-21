package com.sweethome.payment.exception;

public class TransactionNotFoundException extends Exception{
    public TransactionNotFoundException(String message){
        super(message);
    }
}
