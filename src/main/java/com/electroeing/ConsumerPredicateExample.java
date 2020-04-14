package com.electroeing;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerPredicateExample {

    static Predicate<Person> heightPredicate = p -> p.getHeight() >= 140;
    static Predicate<Person> malePredicate = p -> p.getGender().equals("Male");
    static BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);
    static Consumer<Person> personConsumer = person -> {
        if (heightPredicate.and(malePredicate).test(person)) {
            hobbiesConsumer.accept(person.getName(), person.getHobbies());
        }
    };

    public static void main(String[] args) {
        final List<Person> personList = PersonRepository.getAllPersons();
        personList.forEach(personConsumer);
    }
}
