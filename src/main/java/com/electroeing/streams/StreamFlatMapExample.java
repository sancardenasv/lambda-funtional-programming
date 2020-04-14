package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    private static final Logger log = LogManager.getLogger(StreamFlatMapExample.class);

    public static void main(String[] args) {
        final List<Integer> oddNumberList = Arrays.asList(1, 3, 5, 7);
        final List<Integer> evenNumberList = Arrays.asList(2, 4, 6, 8);

        final List<List<Integer>> listList = Arrays.asList(oddNumberList, evenNumberList);
        log.info("List before flattening: {}", listList);

        final List<Integer> integerList = listList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        log.info("List after flattening: {}", integerList);

        final List<String> hobbiesList = getDistinctHobbiesList(PersonRepository.getAllPersons());
        log.info("List of hobbies: {}", hobbiesList);
        log.info("Hobbies Count: {}", countHobbies(PersonRepository.getAllPersons()));

    }

    private static List<String> getDistinctHobbiesList(List<Person> personList) {
        return personList.stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static long countHobbies(List<Person> personList) {
        return personList.stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .count();
    }
}
