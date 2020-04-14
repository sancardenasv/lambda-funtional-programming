package com.electroeing;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> lessThan = n -> (n <= 50);
        Predicate<Integer> graterThan = n -> (n >= 100);
        Predicate<Integer> equalsTo = n -> (n == 0);

        boolean result = lessThan.and(graterThan).and(equalsTo).test(70);
        System.out.println("Result: " + result);
        boolean result2 = lessThan.or(graterThan).or(equalsTo).negate().test(150);
        System.out.println("Result2: " + result2);
    }
}
