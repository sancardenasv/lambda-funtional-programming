package com.electroeing.streams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumericStreamFactoryAggregationExample {
    private static final Logger log = LogManager.getLogger(NumericStreamFactoryAggregationExample.class);

    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 50).sum();
        log.info("Sum Result: {}", sum);
        final OptionalInt max = IntStream.rangeClosed(1, 50).max();
        log.info("Max Result: {}", max.orElse(0));
        final OptionalInt min = IntStream.rangeClosed(1, 50).min();
        log.info("Min Result: {}", min.orElse(0));
        final OptionalDouble avg = IntStream.rangeClosed(1, 50).average();
        log.info("Average Result: {}", avg.orElse(0));
    }
}
