package com.electroeing.streams.terminal;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamJoiningExample {
    private static final Logger log = LogManager.getLogger(StreamJoiningExample.class);

    public static void main(String[] args) {
        char[] ch = {'a', 'b', 'c', 'd'};
        String joined = Stream.of(ch).map(String::new).collect(Collectors.joining("-", "[", "]"));
        log.info("Joined char sequence: {}", joined);

        log.info("Joined names: {}", concatenateNames());
    }

    private static String concatenateNames() {
        return PersonRepository.getAllPersons().stream()
                .map(Person::getName)
                .collect(Collectors.joining("-"));
    }
}
