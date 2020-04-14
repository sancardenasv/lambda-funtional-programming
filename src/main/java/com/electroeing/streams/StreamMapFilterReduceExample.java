package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

public class StreamMapFilterReduceExample {
    private static final Logger log = LogManager.getLogger(StreamMapFilterReduceExample.class);

    public static void main(String[] args) {
        Predicate<Person> filterByHeight = p -> p.getHeight() >= 140;
        Predicate<Person> filterByGender = p -> "Male".equals(p.getGender());

        final Integer kidsCount = PersonRepository.getAllPersons().stream()
                .filter(filterByHeight.and(filterByGender))
                .map(Person::getKids)
                .reduce(0, Integer::sum);
        log.info("Total of kids: {}", kidsCount);
    }
}
