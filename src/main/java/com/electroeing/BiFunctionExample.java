package com.electroeing;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
    static Predicate<Person> p1 = p -> p.getHeight() >= 140;
    static Predicate<Person> p2 = p -> "Male".equals(p.getGender());

    static BiFunction<Integer, Integer, Integer> sum = Integer::sum;
    static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> salaries = (personList, predicate) -> {
        Map<String, Double> map = new HashMap<>();
        personList.forEach(p -> {
            if (predicate.test(p)) {
                map.put(p.getName(), p.getSalary());
            }
        });
        return map;
    };
    public static void main(String[] args) {
        System.out.println("Result: " + sum.apply(10, 6));
        final List<Person> personList = PersonRepository.getAllPersons();

        final Map<String, Double> salaryMap = salaries.apply(personList, p1.and(p2));
        System.out.println("Result: " + salaryMap);
    }
}
