package com.kairos.exception;


import com.kairos.rest.exception.FizzBuzzException;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RestResponseEntityExceptionHandlerTest {

    private RestResponseEntityExceptionHandler target = new RestResponseEntityExceptionHandler();

    @Test
    public void shouldPopulateExceptionDataForCatchAllHandler() {
        ResponseEntity<ExceptionResponse> response = target.handleAllExceptions(new Exception("msg"));

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody().getTimestamp()).isInSameMinuteWindowAs(new Date());
        assertThat(response.getBody().getMessage()).isEqualTo("msg");
    }

    @Test
    public void shouldPopulateExceptionDataForFizzBuzzHandler() {
        ResponseEntity<ExceptionResponse> response = target.handleFizzBuzzException(new FizzBuzzException("msg"));

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody().getTimestamp()).isInSameMinuteWindowAs(new Date());
        assertThat(response.getBody().getMessage()).isEqualTo("msg");
    }
}