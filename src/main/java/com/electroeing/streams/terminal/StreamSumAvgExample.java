package com.electroeing.streams.terminal;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamSumAvgExample {
    private static final Logger log = LogManager.getLogger(StreamSumAvgExample.class);

    public static void main(String[] args) {
        log.info("Total kids sum: {}", totalKids());
        log.info("Height average: {}", heightAverage());
    }

    private static int totalKids() {
        return PersonRepository.getAllPersons().stream()
                .mapToInt(Person::getKids).sum();
    }

    private static double heightAverage() {
        return PersonRepository.getAllPersons().stream()
                .mapToInt(Person::getHeight).average().orElse(0);
    }
}
