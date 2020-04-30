package com.electroeing.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumericStreamMapExample {
    private static final Logger log = LogManager.getLogger(NumericStreamMapExample.class);

    public static void main(String[] args) {
        log.info("Map to double sum result: {}", mapToDouble());
        log.info("Map to long sum result: {}", mapToLong());
        log.info("Map to object result: {}", mapToObject());
    }

    private static double mapToDouble() {
        return IntStream.rangeClosed(1, 10).mapToDouble(n -> n).sum();
    }

    private static long mapToLong() {
        return IntStream.rangeClosed(1, 10).mapToLong(n -> n).sum();
    }

    private static List<Integer> mapToObject() {
        return IntStream.rangeClosed(1, 10)
                // instead of using .mapToObj(x -> x) use boxed()
                .boxed()
                .collect(Collectors.toList());
    }
}
