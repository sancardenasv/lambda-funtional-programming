package com.electroeing;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionPersonExample {
    static Predicate<Person> p1 = p -> p.getHeight() >= 140;
    static Predicate<Person> p2 = p -> "Male".equals(p.getGender());
    static Function<List<Person>, Map<String, Double>> f2 = personList -> {
        Map<String, Double> map = new HashMap<>();
        personList.forEach(p -> {
            if (p1.and(p2).test(p)) {
                map.put(p.getName(), p.getSalary());
            }
        });
        return map;
    };

    public static void main(String[] args) {
        final List<Person> personList = PersonRepository.getAllPersons();

        final Map<String, Double> salaryMap = f2.apply(personList);
        System.out.println("Result: " + salaryMap);
    }
}
