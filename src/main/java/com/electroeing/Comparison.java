package com.electroeing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Comparison {

    public static void main(String[] args) {
        // Before
        int total = 0;
        for (int i = 0; i <= 50; i++) {
            total += i;
        }
        System.out.println("Total is: " + total);

        // After
        int newTotal = IntStream.rangeClosed(0, 50)
                .map(Integer::new)
                .sum();
        System.out.println("New Total is: " + newTotal);


        // Lists
        final List<String> names = Arrays.asList("Sam", "Pedro", "Bills", "Sam");
        // Before
        final ArrayList<String> uniqueList = new ArrayList<>();
        for (String name : names) {
            if (!uniqueList.contains(name)){
                uniqueList.add(name);
            }
        }
        System.out.println("Unique list: " + uniqueList);
        // After
        List<String> newUniqueValues = names.stream().distinct().collect(Collectors.toList());
        System.out.println("New Unique list: " + newUniqueValues);

    }
}
