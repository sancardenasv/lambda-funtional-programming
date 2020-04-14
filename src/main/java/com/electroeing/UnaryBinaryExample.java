package com.electroeing;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryExample {
    static UnaryOperator<String> uo1 = name -> name.toUpperCase();
    static UnaryOperator<Integer> uo2 = n -> n + 10;
    static Comparator<Integer> c1 = (a, b) -> a.compareTo(b);
    static Comparator<String> c2 = (s1, s2) -> Integer.compare(s1.length(), s2.length());


    public static void main(String[] args) {
        System.out.println("Result 1: " + uo1.apply("java8"));
        System.out.println("Result 2: " + uo2.apply(8));

        BinaryOperator<Integer> bo1 = BinaryOperator.maxBy(c1);
        System.out.println(bo1.apply(4, 8));
        BinaryOperator<String> bo2 = BinaryOperator.minBy(c2);
        System.out.println(bo2.apply("java", "functionality"));

    }
}
