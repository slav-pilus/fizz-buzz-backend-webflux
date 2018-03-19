package com.kairos.rest;

import com.kairos.rest.exception.FizzBuzzException;
import com.kairos.rest.vm.FizzBuzzVM;
import com.kairos.service.FizzBuzzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzResourceTest {

    @InjectMocks
    private FizzBuzzResource target = new FizzBuzzResource();

    @Mock
    private FizzBuzzService fizzBuzzService;

    @Test
    public void fizzBuzzShouldGetGameResultFromService() {
        when(fizzBuzzService.getResult(5)).thenReturn(Optional.of("Buzz"));

        target.play(5);

        verify(fizzBuzzService).getResult(5);
    }

    @Test(expected = FizzBuzzException.class)
    public void fizzBuzzShouldHandleNullInput() {
        target.play(null);

        verify(fizzBuzzService, never()).getResult(null);
    }

    @Test
    public void shouldReturnViewModel() {
        when(fizzBuzzService.getResult(3)).thenReturn(Optional.of("Fizz"));

        Mono<FizzBuzzVM> play = target.play(3);

        play.subscribe(value -> {
            System.out.println("in");
            assertThat(value.getResult()).isEqualTo("Fizz");
            assertThat(value.getInput()).isEqualTo(3);
        });
    }

    @Test(expected = FizzBuzzException.class)
    public void shouldThrowExceptionWhenServiceCallNull() {
        target.play(3);
    }

    @Test(expected = FizzBuzzException.class)
    public void shouldErrorOnRoot() {
        target.rootMapping();
    }
}