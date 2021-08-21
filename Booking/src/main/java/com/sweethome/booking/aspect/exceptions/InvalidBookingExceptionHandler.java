package com.sweethome.booking.aspect.exceptions;

import com.sweethome.booking.exception.InvalidBookingIdException;
import com.sweethome.booking.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InvalidBookingExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<ErrorResponse> handleInvalidBookingIdException(InvalidBookingIdException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(400);
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
