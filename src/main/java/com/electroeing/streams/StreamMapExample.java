package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample {
    private static final Logger log = LogManager.getLogger(StreamMapExample.class);

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Banana", "Pineapple");

        final List<Integer> fruitLengthList = fruits.stream().map(String::length)
                .collect(Collectors.toList());

        log.info("Lengths of the fruits names: {}", fruitLengthList);

        final List<String> nameToUpperCase = nameToUpperCase(PersonRepository.getAllPersons());
        log.info("Upper case result: {}", nameToUpperCase);

    }

    private static List<String> nameToUpperCase(List<Person> personList) {
        return personList.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
