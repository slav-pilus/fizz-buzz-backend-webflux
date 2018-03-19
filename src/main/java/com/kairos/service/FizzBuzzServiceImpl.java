package com.kairos.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    @Override
    public Optional<String> getResult(Integer input) {
        if (input == null) {
            return Optional.empty();
        }

        String result = "";

        if (input % 3 == 0) {
            result += "Fizz";
        }
        if (input % 5 == 0) {
            result += "Buzz";
        }

        return result.isEmpty() ? Optional.of(String.valueOf(input)) : Optional.of(result);
    }
}
