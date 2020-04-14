package com.electroeing;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerRepositoryExample {
    /* p -> System.out.println(p); */
    static Consumer<Person> c1 = System.out::println;
    static Consumer<Person> c2 = p -> System.out.println(p.getName().toUpperCase());
    static Consumer<Person> c3 = p -> System.out.println(p.getHobbies());

    private static List<Person> personList = PersonRepository.getAllPersons();

    public static void main(String[] args) {
        c1.andThen(c2).andThen(c3).accept(PersonRepository.getPerson());

//        printNameAndHobbies();
        printWithCondition();

    }

    static void printNameAndHobbies() {
        personList.forEach(c1.andThen(c2).andThen(c3));
    }

    static void printWithCondition() {
        personList.forEach(p -> {
            if (p.getGender().equals("Male") && p.getHeight() >= 140) {
                c1.andThen(c2).andThen(c3).accept(p);
            }
        });
    }
}
