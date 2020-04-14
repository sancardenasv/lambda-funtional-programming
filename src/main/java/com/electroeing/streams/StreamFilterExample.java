package com.electroeing.streams;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFilterExample {
    private static final Logger log = LogManager.getLogger(StreamFilterExample.class);

    public static void main(String[] args) {
        final List<String> nameList = Arrays.asList("Sam", "Anderson", "Peter", "Nancy");
        log.info("All names: {}", nameList);

        final List<String> filteredNameList = nameList.stream()
                .filter(n -> n.length() > 3)
                .collect(Collectors.toList());
        log.info("Filtered name list: {}", filteredNameList);

        log.info("Height filtered person list");

        final Predicate<Person> heightPredicate = p -> p.getHeight() >= 140;
        final Predicate<Person> genderPredicate = p -> "Male".equals(p.getGender());
        PersonRepository.getAllPersons().stream()
                .filter(heightPredicate.and(genderPredicate))
                .collect(Collectors.toList()).forEach(log::info);
    }
}
