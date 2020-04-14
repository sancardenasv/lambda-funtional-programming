package com.electroeing;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        // Before
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("C1 - Compare 15 and 15: " + c1.compare(15, 15));

        // After
        Comparator<Integer> c2 = (Integer::compareTo);
        System.out.println("C2 - Compare 15 and 15: " + c2.compare(15, 15));
        System.out.println("C2 - Compare 25 and 15: " + c2.compare(25, 15));
        System.out.println("C2 - Compare 25 and 15: " + c2.compare(15, 40));
    }
}
