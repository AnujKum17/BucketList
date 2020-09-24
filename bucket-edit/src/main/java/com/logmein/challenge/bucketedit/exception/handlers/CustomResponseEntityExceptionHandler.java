package com.logmein.challenge.bucketedit.exception.handlers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.logmein.challenge.bucketedit.exception.ItemAlreadyExistsException;
import com.logmein.challenge.bucketedit.exception.ObjectNotFoundException;
import com.logmein.challenge.bucketedit.exception.ValidationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ItemAlreadyExistsException.class)
    protected ResponseEntity<Object> handleItemAlreadyExists(ItemAlreadyExistsException ex) {
        String error = "Item already exists in the bucket.";
        return buildResponseEntity(new CustomExceptionObject(HttpStatus.CONFLICT,error,ex));
    }
    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<Object> handleValidationErrors(ValidationException ex){
        String error = "Validation error for inputted object or parameters.";
        return buildResponseEntity(new CustomExceptionObject(HttpStatus.BAD_REQUEST,error,ex));
    }
    @ExceptionHandler(ObjectNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(ObjectNotFoundException ex){
        String error = "No bucket list found for provided user.";
        return buildResponseEntity(new CustomExceptionObject(HttpStatus.NOT_FOUND,error,ex));
    }
    private ResponseEntity<Object> buildResponseEntity(CustomExceptionObject customExceptionObject) {
        return new ResponseEntity<Object>(customExceptionObject, customExceptionObject.getStatus());
    }
}
