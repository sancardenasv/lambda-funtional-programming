package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import java.util.Optional;
import java.util.function.Predicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamFindAnyFirstExample {
    private static final Logger log = LogManager.getLogger(StreamFindAnyFirstExample.class);

    private static Predicate<Person> height = p -> p.getHeight() >= 140;
    private static Predicate<Person> female = p -> "Female".equals(p.getGender());

    public static void main(String[] args) {
        log.info("Find any result: {}", findAny().orElse(null));
        log.info("Find first result: {}", findFirst().orElse(null));
    }

    private static Optional<Person> findAny() {
        return PersonRepository.getAllPersons().stream()
                .filter(height)
                .findAny();
    }

    private static Optional<Person> findFirst() {
        return PersonRepository.getAllPersons().stream()
                .filter(female)
                .findFirst();
    }
}
