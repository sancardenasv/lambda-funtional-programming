package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStreamExample {
    private static final Logger log = LogManager.getLogger(SimpleStreamExample.class);

    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1,2,3,4,5,6);
        s1.forEach(log::info);
        log.info("==========================");

        Predicate<Person> p1 = p -> p.getHeight() >= 140;
        Predicate<Person> p2 = p -> "Male".equals(p.getGender());

        Map<String, List<String>> personHobbies = PersonRepository.getAllPersons()
                .stream()
                .filter(p1.and(p2))
                .collect(Collectors.toMap(Person::getName, Person::getHobbies));

        log.info("Person Hobbies: {}", personHobbies);

        List<String> allHobbiesList = PersonRepository.getAllPersons()
                .stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        log.info("All person hobbies: {}", allHobbiesList);
    }
}
