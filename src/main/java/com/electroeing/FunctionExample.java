package com.electroeing;

import java.util.function.Function;

public class FunctionExample {
    static Function<String, String> toUpperCase = name -> name.toUpperCase();
    static Function<String, String> concatenate = name -> name.concat(" features");

    public static void main(String[] args) {
//        System.out.println("Result: " + toUpperCase.apply("java"));
//        System.out.println("Result: " + concatenate.apply("java"));
        System.out.println("And then result: " + toUpperCase.andThen(concatenate).apply("java"));
        System.out.println("Compose result: " + toUpperCase.compose(concatenate).apply("java"));
    }
}
