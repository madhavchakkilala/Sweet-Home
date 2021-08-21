package com.sweethome.booking.aspect.exceptions;

import com.sweethome.booking.exception.InvalidDatesPassedException;
import com.sweethome.booking.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InvalidDatesPassedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<ErrorResponse> handleInvalidDatesPassedException(InvalidDatesPassedException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatusCode(400);
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
