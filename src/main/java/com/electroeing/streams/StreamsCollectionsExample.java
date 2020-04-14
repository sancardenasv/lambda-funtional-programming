package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCollectionsExample {
    private static final Logger log = LogManager.getLogger(StreamsCollectionsExample.class);
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Adan");
        names.add("Nancy");

        for (String name: names) {
            log.info("1 >>>> {}", name);
        }
        for (String name: names) {
            log.info("2 >>>> {}", name);
        }

        final Stream<String> stream = names.stream();
        stream.forEach(n -> log.info("<<<< {}", n));
        // stream.forEach(n -> log.info("<<<< {}", n)); // Will set error as Stream is already closed in the previous iteration

        PersonRepository.getAllPersons().stream()
                .peek(p -> log.info("Person info {}", p))
                .map(Person::getName)
                .peek(n -> log.info("Person Name {}", n))
                .collect(Collectors.toList());
    }
}
