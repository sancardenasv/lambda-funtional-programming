package com.electroeing.streams.terminal;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamPartitioningExample {
    private static final Logger log = LogManager.getLogger(StreamPartitioningExample.class);

    public static void main(String[] args) {
        byHeight();
        byHeightMap();
    }

    private static void byHeight() {
        Predicate<Person> higherThan = person -> person.getHeight() >= 140;

        final Map<Boolean, List<Person>> collect = PersonRepository.getAllPersons().stream()
                .collect(Collectors.partitioningBy(higherThan));

        collect.forEach((key, value) -> log.info("Grouped by {}: {}", key, value));
    }

    private static void byHeightMap() {
        Predicate<Person> higherThan = person -> person.getHeight() >= 140;

        final Map<Boolean, Map<String, List<String>>> collect = PersonRepository.getAllPersons().stream()
                .collect(Collectors.partitioningBy(higherThan, Collectors.toMap(Person::getName, Person::getHobbies)));

        collect.forEach((key, value) -> log.info("Map result grouped by {}: {}", key, value));
    }
}
