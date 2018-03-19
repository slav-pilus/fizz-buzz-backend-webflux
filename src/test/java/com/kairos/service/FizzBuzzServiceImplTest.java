package com.kairos.service;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class FizzBuzzServiceImplTest {

    private FizzBuzzService target = new FizzBuzzServiceImpl();

    @Test
    public void shouldReturnSameNumber() {
        Optional<String> result = target.getResult(7);

        assertThat(result.get()).isEqualTo("7");
    }

    @Test
    public void shouldReturnFizzWhenThree() {
        Optional<String> result = target.getResult(3);

        assertThat(result.get()).isEqualTo("Fizz");
    }

    @Test
    public void shouldReturnBuzzWhenFive() {
        Optional<String> result = target.getResult(5);

        assertThat(result.get()).isEqualTo("Buzz");
    }

    @Test
    public void shouldReturnFizzBuzzWhenFifteen() {
        Optional<String> result = target.getResult(15);

        assertThat(result.get()).isEqualTo("FizzBuzz");
    }

    @Test
    public void shouldReturnFizzWhenDivisibleByThree() {
        Optional<String> result = target.getResult(3 * 3);

        assertThat(result.get()).isEqualTo("Fizz");
    }

    @Test
    public void shouldReturnBuzzWhenDivisibleByFive() {
        Optional<String> result = target.getResult(5 * 2);

        assertThat(result.get()).isEqualTo("Buzz");
    }

    @Test
    public void shouldReturnFizzBuzzWhenDivisibleByThreeAndFive() {
        Optional<String> result = target.getResult((5 * 2) * (3 * 3));

        assertThat(result.get()).isEqualTo("FizzBuzz");
    }

    @Test
    public void shouldHandleNull() {
        Optional<String> result = target.getResult(null);

        assertThat(result.orElse("no value")).isEqualTo("no value");
    }

    @Test
    public void shouldHandleZero() {
        Optional<String> result = target.getResult(0);

        assertThat(result.get()).isEqualTo("FizzBuzz");
    }

    @Test
    public void shouldHandleNegativeNumbers() {
        Optional<String> result = target.getResult(-15);

        assertThat(result.get()).isEqualTo("FizzBuzz");
    }
}