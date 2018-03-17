package com.kairos.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FizzBuzzException extends RuntimeException {

    public FizzBuzzException(String msg) {
       super(msg);
    }
}
