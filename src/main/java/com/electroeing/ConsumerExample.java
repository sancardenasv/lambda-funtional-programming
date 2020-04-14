package com.electroeing;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> con1 = s -> System.out.println(s.toLowerCase());
        Consumer<String> con2 = s -> System.out.println(s.replace("J", "j"));

        con1.andThen(con2).accept("JAVA8");
    }
}
