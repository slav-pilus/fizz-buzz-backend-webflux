package com.kairos.exception;

import com.kairos.rest.exception.FizzBuzzException;
import lombok.Data;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.util.Date;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ExceptionHandlerExceptionResolver {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FizzBuzzException.class)
    public final ResponseEntity<ExceptionResponse> handleFizzBuzzException(FizzBuzzException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@Data
class ExceptionResponse {

    @NonNull
    private Date timestamp;
    @NonNull
    private String message;
}