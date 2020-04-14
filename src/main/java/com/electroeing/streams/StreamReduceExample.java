package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    private static final Logger log = LogManager.getLogger(StreamReduceExample.class);

    public static void main(String[] args) {
        final List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        int sum = integerList.stream()
                .mapToInt(i -> i).sum();
        log.info("Sum result: {}", sum);

        final long count = integerList.stream()
                .mapToInt(i -> i).count();
        log.info("Count result: {}", count);

        final Integer multiplicationResult = integerList.stream()
                .reduce(1, (a, b) -> a * b);
        log.info("Multiplication result: {}", multiplicationResult);

        final String namesString = PersonRepository.getAllPersons().stream()
                .map(Person::getName)
                .reduce("", (a, b) -> a.concat(b).concat(","));
        log.info("Concatenated names: {}", namesString);

        final Optional<Person> tallestPerson = PersonRepository.getAllPersons().stream()
                .reduce((x, y) -> x.getHeight() > y.getHeight() ? x : y);
        tallestPerson.ifPresent(p -> log.info("The tallest person is {} with a height of {}", p.getName(), p.getHeight()));
    }
}
