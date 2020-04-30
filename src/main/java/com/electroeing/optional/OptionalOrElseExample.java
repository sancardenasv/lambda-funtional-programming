package com.electroeing.optional;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OptionalOrElseExample {
    private static final Logger log = LogManager.getLogger(OptionalOrElseExample.class);

    public static void main(String[] args) {
        orElse(PersonRepository.getPerson());
        orElse(new Person());
        orElse(null);

        orElseGet(PersonRepository.getPerson());
        orElseGet(new Person());
        orElseGet(null);

        orElseThrow(PersonRepository.getPerson());
        orElseThrow(new Person());
        orElseThrow(null);
    }

    private static void orElse(Person person) {
        final Optional<Person> personOptional = Optional.ofNullable(person);
        // final String name = person.isPresent() ? person.get().getName() : "No data found";
        final String name = personOptional.map(Person::getName).orElse("No data found");
        log.info("[orElse] Person name: {}", name);
    }
    private static void orElseGet(Person person) {
        final Optional<Person> personOptional = Optional.ofNullable(person);
        final String name = personOptional.map(Person::getName)
                .orElseGet(() -> PersonRepository.getPerson().getName());
        log.info("[orElseGet] Person name: {}", name);
    }

    private static void orElseThrow(Person person) {
        try {
            final Optional<Person> personOptional = Optional.ofNullable(person);
            final String name = personOptional.map(Person::getName)
                    .orElseThrow(() -> new IllegalArgumentException("Manually Thrown due to: person or person name null"));
            log.info("[orElseThrow] Person name: {}", name);
        } catch (IllegalArgumentException e) {
            log.error("[orElseThrow] Catch error", e);
        }
    }
}
