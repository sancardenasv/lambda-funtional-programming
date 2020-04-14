package com.electroeing;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatePersonExample {
    static Predicate<Person> heightPredicate = p -> p.getHeight() >= 140;
    static Predicate<Person> malePredicate = p -> p.getGender().equals("Male");

    public static void main(String[] args) {
        List<Person> personList = PersonRepository.getAllPersons();

        List<Person> filteredPersonList = personList.stream()
                .filter(heightPredicate.and(malePredicate)).collect(Collectors.toList());

        System.out.println(personList);
        System.out.println(filteredPersonList);
    }
}
