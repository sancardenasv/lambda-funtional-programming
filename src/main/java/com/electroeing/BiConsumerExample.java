package com.electroeing;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        ObjIntConsumer<Integer> i = (a, b) -> System.out.println("Sum result: " + (a + b));
        i.accept(3, 5);
        BiConsumer<Integer, Integer> con1 = (a, b) -> System.out.println("Sum result: " + (a + b));
        con1.accept(3, 5);

        List<Integer> list1 = Arrays.asList(10, 4, 7);
        List<Integer> list2 = Arrays.asList(3, 1);

        BiConsumer<List<Integer>, List<Integer>> con2 = (l1, l2) -> {
            if (l1.size() == l2.size()) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        };
        con2.accept(list1, list2);


        BiConsumer<Integer, Integer> add = (a, b) -> System.out.println("Sum result: " + (a + b));
        BiConsumer<Integer, Integer> subtract = (a, b) -> System.out.println("Subtraction result: " + (a - b));
        BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println("Multiplication result: " + (a * b));
        add.andThen(subtract).andThen(multiply).accept(10, 20);

    }
}
