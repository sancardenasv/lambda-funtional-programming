package com.electroeing.streams.terminal;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamGroupingExample {
    private static final Logger log = LogManager.getLogger(StreamGroupingExample.class);
    private static final String GROUPED_BY = "Grouped by {}:\n{}";

    public static void main(String[] args) {
        groupByGender();
        groupByHeightRange();
        twoLevelGrouping();
        twoLevelGroupingCount();
    }

    private static void groupByGender() {
        final Map<String, List<Person>> genderGrouped = PersonRepository.getAllPersons().stream()
                .collect(Collectors.groupingBy(Person::getGender));

        genderGrouped.forEach((key, value) -> log.info(GROUPED_BY, key, value));
    }

    private static void groupByHeightRange() {
        PersonRepository.getAllPersons().stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.getHeight() >= 158) {
                        return "Tall";
                    } else if (p.getHeight() >= 140) {
                        return "Average";
                    } else if (p.getHeight() >= 125) {
                        return "Short";
                    }
                    return "Tiny";
                })).forEach((key, value) -> log.info(GROUPED_BY, key, value));
    }

    private static void twoLevelGrouping() {
        PersonRepository.getAllPersons().stream()
                .collect(
                        Collectors.groupingBy(Person::getGender,
                                Collectors.groupingBy(p -> p.getHeight() >= 140 ? "Tall" : "Short")))
                .forEach((key, value) -> log.info(GROUPED_BY, key, value));
    }

    private static void twoLevelGroupingCount() {
        PersonRepository.getAllPersons().stream()
                .collect(Collectors.groupingBy(Person::getSalary, Collectors.summingInt(Person::getKids)))
                .forEach((key, value) -> log.info(GROUPED_BY, key, value));
    }
}
