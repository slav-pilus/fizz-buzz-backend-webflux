package com.kairos.rest;

import com.kairos.rest.exception.FizzBuzzException;
import com.kairos.rest.vm.FizzBuzzVM;
import com.kairos.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "${settings.cors-origin}")
public class FizzBuzzResource {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping("/")
    public void rootMapping() {
        throw new FizzBuzzException("Please supply input");
    }

    @GetMapping("/{number}")
    public Mono<FizzBuzzVM> play(@PathVariable Integer number) {
        validate(number);

        Optional<String> gameResult = fizzBuzzService.getResult(number);

        return Mono.just(new FizzBuzzVM(number, gameResult.orElseThrow(() -> new FizzBuzzException("Cannot calculate result"))));
    }

    private void validate(Integer number) {
        if (number == null) {
            throw new FizzBuzzException("Wrong input!");
        }
    }
}
