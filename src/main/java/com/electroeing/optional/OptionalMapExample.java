package com.electroeing.optional;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OptionalMapExample {
    private static final Logger log = LogManager.getLogger(OptionalMapExample.class);

    public static void main(String[] args) {
        optionalMap();
        optionalFlatMap();
    }

    private static void optionalMap() {
        final String name = Optional.of(PersonRepository.getPerson())
                .map(Person::getName).orElse("No name found");
        log.info("Name: {}", name);
    }

    private static void optionalFlatMap() {
        Optional.of(PersonRepository.getPerson())
                .flatMap(person -> Optional.ofNullable(person.getAddress()))
                .ifPresent(address -> log.info("Address: {}", address));
    }
}
