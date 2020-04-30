package com.electroeing.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamBoxingUnboxingExample {
    private static final Logger log = LogManager.getLogger(StreamBoxingUnboxingExample.class);

    public static void main(String[] args) {
        boxing().forEach(log::info);
        final int sumResult = sumNumbers(boxing());
        log.info("Sum result is {}", sumResult);
    }

    private static int sumNumbers(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static List<Integer> boxing() {
        return IntStream.rangeClosed(0, 40).boxed().collect(Collectors.toList());
    }
}
