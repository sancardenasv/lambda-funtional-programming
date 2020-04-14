package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMinMaxExample {
    private static final Logger log = LogManager.getLogger(StreamMinMaxExample.class);

    public static void main(String[] args) {
        getTallestPerson().ifPresent(p -> log.info("Tallest Person Found: {}", p));
        getShortestPerson().ifPresent(p -> log.info("Shortest Person Found: {}", p));
        log.info("Tallest person list: {}", StreamMinMaxExample::getTallestPersonList);
    }

    private static Optional<Person> getTallestPerson() {
        return PersonRepository.getAllPersons().stream()
                .max(Comparator.comparing(Person::getHeight));
    }

    private static Optional<Person> getShortestPerson() {
        return PersonRepository.getAllPersons().stream()
                .min(Comparator.comparing(Person::getHeight));
    }

    private static List<Person> getTallestPersonList() {
        List<Person> personList = new ArrayList<>();
        final Optional<Person> tallestPerson = getTallestPerson();
        if (tallestPerson.isPresent()) {
            personList = PersonRepository.getAllPersons().stream()
                    .filter(person -> person.getHeight() == tallestPerson.get().getHeight())
                    .collect(Collectors.toList());
        }
        return personList;
    }
}
