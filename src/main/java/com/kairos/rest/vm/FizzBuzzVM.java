package com.kairos.rest.vm;

import lombok.Data;
import lombok.NonNull;

@Data
public class FizzBuzzVM {

    @NonNull
    Integer input;
    @NonNull
    String result;
}
