package com.electroeing;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerPersonExample {

    public static void main(String[] args) {
        printPersonDetails();
    }

    static void printPersonDetails() {
        BiConsumer<String, List<String>> personConsumer =
                (name, hobbies) -> System.out.println(name + ": " + hobbies);
        BiConsumer<String, Double> salaryConsumer =
                (name, salary) -> System.out.println(name + ": " + salary);

        List<Person> personList = PersonRepository.getAllPersons();
        personList.forEach(p -> {
            personConsumer.accept(p.getName(), p.getHobbies());
            salaryConsumer.accept(p.getName(), p.getSalary());
        });
    }
}
