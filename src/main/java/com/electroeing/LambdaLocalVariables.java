package com.electroeing;

import java.util.function.IntConsumer;

public class LambdaLocalVariables {
    static int k = 0;

    public static void main(String[] args) {
        int i = 10;

        IntConsumer c1 = j -> {
            // i += j; => Can not modify i
            // Instance variables can be modified
            k += j;
            System.out.println("Value is: i + j = " + (i + j) + "| k = " + k);
        };

        c1.accept(15);
    }
}
