package com.kairos.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    @Override
    public String getResult(Integer input) {
        if (input == null) {
            return null;
        }

        String result = "";

        if (input % 3 == 0) {
            result += "Fizz";
        }
        if (input % 5 == 0) {
            result += "Buzz";
        }

        return result.isEmpty() ? String.valueOf(input) : result;
    }
}
