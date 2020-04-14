package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamAllAnyMatchExample {
    private static final Logger log = LogManager.getLogger(StreamAllAnyMatchExample.class);

    public static void main(String[] args) {
        BiPredicate<String, Integer> length = (s, l) -> s.length() > l;

        final List<String> fruitList = Arrays.asList("Apple", "Orange", "Grapes", "Banana", "Pineapple");
        final boolean areAllLongEnough = fruitList.stream()
                .allMatch(s -> length.test(s, 7));
        log.info("Are all elements length grater than 7: {}", areAllLongEnough);
        final boolean isAtLeastOneElementLongEnough = fruitList.stream()
                .anyMatch(s -> length.test(s, 7));
        log.info("Is there at least one element length grater than 7: {}", isAtLeastOneElementLongEnough);

        Predicate<Person> height = p -> p.getHeight() >= 140;
        Predicate<Person> male = p -> "Male".equals(p.getGender());
        final boolean allPersonHigherAndMale = PersonRepository.getAllPersons().stream()
                .allMatch(height.and(male));
        log.info("All persons higher than 140 and Male: {}", allPersonHigherAndMale);
        final boolean atLeastOnePersonHigherAndMale = PersonRepository.getAllPersons().stream()
                .anyMatch(height.and(male));
        log.info("At least one person higher than 140 and Male: {}", atLeastOnePersonHigherAndMale);
    }
}
