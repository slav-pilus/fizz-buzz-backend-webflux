package com.kairos.service;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class FizzBuzzServiceImplTest {

    private FizzBuzzService target = new FizzBuzzServiceImpl();

    @Test
    public void shouldReturnSameNumber() {
        String result = target.getResult(7);

        assertThat(result).isEqualTo("7");
    }

    @Test
    public void shouldReturnFizzWhenThree() {
        String result = target.getResult(3);

        assertThat(result).isEqualTo("Fizz");
    }

    @Test
    public void shouldReturnBuzzWhenFive() {
        String result = target.getResult(5);

        assertThat(result).isEqualTo("Buzz");
    }

    @Test
    public void shouldReturnFizzBuzzWhenFifteen() {
        String result = target.getResult(15);

        assertThat(result).isEqualTo("FizzBuzz");
    }

    @Test
    public void shouldReturnFizzWhenDivisibleByThree() {
        String result = target.getResult(3 * 3);

        assertThat(result).isEqualTo("Fizz");
    }

    @Test
    public void shouldReturnBuzzWhenDivisibleByFive() {
        String result = target.getResult(5 * 2);

        assertThat(result).isEqualTo("Buzz");
    }

    @Test
    public void shouldReturnFizzBuzzWhenDivisibleByThreeAndFive() {
        String result = target.getResult((5 * 2) * (3 * 3));

        assertThat(result).isEqualTo("FizzBuzz");
    }

    @Test
    public void shouldHandleNull() {
        String result = target.getResult(null);

        assertThat(result).isNull();
    }

    @Test
    public void shouldHandleZero() {
        String result = target.getResult(0);

        assertThat(result).isEqualTo("FizzBuzz");
    }

    @Test
    public void shouldHandleNegativeNumbers() {
        String result = target.getResult(-15);

        assertThat(result).isEqualTo("FizzBuzz");
    }
}