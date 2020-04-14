package com.electroeing;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReferenceExample {
    static Function<String, String> f1 = String::toUpperCase;
    static BiPredicate<Person, Integer> p1 = MethodReferenceExample::heightCheck;

    public static void main(String[] args) {
        final int compare = MethodReferenceExample.compare(10, 20);
        System.out.println(compare);

        // By method reference
        final Comparator<Integer> compare1 = MethodReferenceExample::compare;
        System.out.println("Result 2: " + compare1.compare(10, 20));

        System.out.println("Method: " + f1.apply("Java8"));

        System.out.println("Predicate: " + p1.test(PersonRepository.getPerson(), 145));
    }

    public static int compare(Integer x, Integer y) {
        return Integer.compare(x, y);
    }

    static boolean heightCheck(Person person, Integer height) {
        System.out.println("Checking height for person: " + person.getHeight() + " With value: " + height);
        return person.getHeight() >= height;
    }
}
