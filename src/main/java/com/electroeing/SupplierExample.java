package com.electroeing;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    static Supplier<List<Person>> s1 = () -> PersonRepository.getAllPersons();
    public static void main(String[] args) {
        final List<Person> personList = s1.get();
        System.out.println("Result: " + personList);
    }
}
