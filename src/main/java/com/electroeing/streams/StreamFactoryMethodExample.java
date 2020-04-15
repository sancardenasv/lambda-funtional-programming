package com.electroeing.streams;

import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamFactoryMethodExample {
    private static final Logger log = LogManager.getLogger(StreamFactoryMethodExample.class);

    public static void main(String[] args) {

        final Stream<Integer> iterate = Stream.iterate(0, x -> x + 5).limit(10);
        iterate.forEach(log::info);

        Stream.generate(Math::random).limit(10).forEach(log::info);

        Stream.of("One", "Two", "Three", "Four").forEach(log::info);
    }
}
