package com.sweethome.payment.aspect.exceptions;


import com.sweethome.payment.exception.TransactionNotFoundException;
import com.sweethome.payment.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
    public class TransactionNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<ErrorResponse>  handleTransactionNotFoundException(TransactionNotFoundException e, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),400);
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
