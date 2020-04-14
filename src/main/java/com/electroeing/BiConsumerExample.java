package com.electroeing;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BiConsumerExample {
    private static final Logger log = LogManager.getLogger(BiConsumerExample.class);
    private static final String SUM_RESULT = "Sum result: {}";

    public static void main(String[] args) {
        ObjIntConsumer<Integer> i = (a, b) -> log.info(SUM_RESULT, (a + b));
        i.accept(3, 5);
        ObjIntConsumer<Integer> con1 = (a, b) -> log.info(SUM_RESULT, (a + b));
        con1.accept(3, 5);

        List<Integer> list1 = Arrays.asList(10, 4, 7);
        List<Integer> list2 = Arrays.asList(3, 1);

        BiConsumer<List<Integer>, List<Integer>> con2 = (l1, l2) -> {
            if (l1.size() == l2.size()) {
                log.info("True");
            } else {
                log.info("False");
            }
        };
        con2.accept(list1, list2);


        BiConsumer<Integer, Integer> add = (a, b) -> log.info(SUM_RESULT, (a + b));
        BiConsumer<Integer, Integer> subtract = (a, b) -> log.info("Subtraction result: {}", (a - b));
        BiConsumer<Integer, Integer> multiply = (a, b) -> log.info("Multiplication result: {}", (a * b));
        add.andThen(subtract).andThen(multiply).accept(10, 20);

    }
}
