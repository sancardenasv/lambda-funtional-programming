package com.electroeing.streams.terminal;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamMappingExample {
    private static final Logger log = LogManager.getLogger(StreamMappingExample.class);

    public static void main(String[] args) {
        log.info("Person names: {}", mapName());
        log.info("Tall person number: {}", countTallPersons());
    }

    private static List<String> mapName() {
        return PersonRepository.getAllPersons().stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    private static Long countTallPersons() {
        return PersonRepository.getAllPersons().stream()
                .filter(p -> p.getHeight() >= 140)
                .count();
    }
}
