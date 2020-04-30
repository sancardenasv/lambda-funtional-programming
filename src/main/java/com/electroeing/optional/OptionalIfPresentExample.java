package com.electroeing.optional;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OptionalIfPresentExample {
    private static final Logger log = LogManager.getLogger(OptionalIfPresentExample.class);

    public static void main(String[] args) {
        final Optional<String> java8 = Optional.of("Java8");
        final Optional<String> java8Null = Optional.empty();
        log.info("Traditional: {}", java8.isPresent() ? java8.get() : "No data");
        java8.ifPresent(s -> log.info("If Present: {}", s));
        log.info("Traditional with null: {}", java8Null.isPresent() ? java8.get() : "No data");
        // Should never print
        java8Null.ifPresent(s -> log.info("If Present with null: {}", s));
    }
}
