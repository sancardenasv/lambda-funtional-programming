package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class StreamCustomSortExample {
    public static final Logger log = LogManager.getLogger(StreamCustomSortExample.class);

    public static void main(String[] args) {
        log.info("Sort by name");
        PersonRepository.getAllPersons().stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(log::info);

        log.info("Sort by height");
        PersonRepository.getAllPersons().stream()
                .sorted(Comparator.comparing(Person::getHeight))
                .forEach(log::info);

        log.info("Sort by name reverse");
        PersonRepository.getAllPersons().stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .forEach(log::info);
    }
}
