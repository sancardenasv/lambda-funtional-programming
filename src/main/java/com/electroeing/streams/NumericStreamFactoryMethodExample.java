package com.electroeing.streams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumericStreamFactoryMethodExample {
    private static final Logger log = LogManager.getLogger(NumericStreamFactoryMethodExample.class);

    public static void main(String[] args) {
        final IntStream intStreamClosed = IntStream.rangeClosed(1, 6);
        final IntStream intStream = IntStream.range(1, 6);
        intStreamClosed.forEach(log::info);
        log.info("====================");
        intStream.forEach(log::info);

        log.info("Long:");
        LongStream.rangeClosed(1, 50).forEach(log::info);
        log.info("Double:");
        LongStream.rangeClosed(1, 50).asDoubleStream().forEach(log::info);
    }
}
