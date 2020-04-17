package com.electroeing.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumericStreamExample {
    private static final Logger log = LogManager.getLogger(NumericStreamExample.class);

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(4, 6 ,1 ,9, 7, 9);

        final int sum = calculateSum(l1);
        log.info("Sum result: {}", sum);
        final int sumWithStream = calculateSumWithStream(IntStream.rangeClosed(1, 6));
        log.info("Sum with stream result: {}", sumWithStream);
    }

    private static int calculateSum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    private static int calculateSumWithStream(IntStream intStream) {
        return intStream.sum();
    }
}
