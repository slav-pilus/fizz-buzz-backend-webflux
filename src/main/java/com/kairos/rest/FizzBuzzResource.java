package com.kairos.rest;

import com.kairos.rest.exception.FizzBuzzException;
import com.kairos.rest.vm.FizzBuzzVM;
import com.kairos.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzResource {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping("/")
    public void rootMapping() {
        throw new FizzBuzzException("Please supply input");
    }

    @GetMapping("/{number}")
    public FizzBuzzVM play(@PathVariable Integer number) {
        validate(number);

        String gameResult = fizzBuzzService.getResult(number);

        if (gameResult == null) {
            throw new FizzBuzzException("Cannot calculate result");
        }
        return new FizzBuzzVM(number, gameResult);
    }

    private void validate(Integer number) {
        if (number == null) {
            throw new FizzBuzzException("Wrong input!");
        }
    }
}
