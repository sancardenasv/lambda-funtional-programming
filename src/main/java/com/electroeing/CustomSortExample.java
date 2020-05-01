package com.electroeing;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class CustomSortExample {
    private static final Logger log = LogManager.getFormatterLogger(CustomSortExample.class);

    private static final Comparator<Person> byName = Comparator.comparing(Person::getName);
    private static final Comparator<Person> byHeight = Comparator.comparing(Person::getHeight);

    public static void main(String[] args) {
        List<Person> personList = PersonRepository.getAllPersons();
        sortByNameAndHeight(personList);
    }

    private static void sortByNameAndHeight(List<Person> personList) {
        personList.sort(Comparator.nullsFirst(byName.thenComparing(byHeight)));
        personList.forEach(log::info);
    }
}
