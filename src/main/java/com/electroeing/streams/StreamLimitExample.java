package com.electroeing.streams;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamLimitExample {
    private static final Logger log = LogManager.getLogger(StreamLimitExample.class);

    public static void main(String[] args) {
        final List<String> fruitList = Arrays.asList("Apple", "Orange", "Grapes", "Banana", "Pineapple");
        fruitList.stream().limit(2)
                .forEach(log::info);

        final List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        final int limit = 4;
        final Integer sum = integerList.stream().limit(limit)
                .reduce(0, Integer::sum);
        log.info("Sum result of first {} numbers: {}", limit, sum);

        final int skip = 2;
        final Integer skipSum = integerList.stream().skip(skip)
                .reduce(0, Integer::sum);
        log.info("Sum result of the numbers skipping {} positions: {}", skip, skipSum);


    }
}
