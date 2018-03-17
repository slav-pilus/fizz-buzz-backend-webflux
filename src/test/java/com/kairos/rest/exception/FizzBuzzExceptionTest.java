package com.kairos.rest.exception;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FizzBuzzExceptionTest {

    @Test
    public void shouldHaveMessage() {
        try {
            throw new FizzBuzzException("msg");
        } catch (FizzBuzzException ex) {
            assertThat(ex.getMessage()).isEqualTo("msg");
        }
    }
}