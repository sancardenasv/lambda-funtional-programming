package com.electroeing;

public class RunnableLambdaExample {
    public static void main(String[] args) {
        // Before
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");
            }
        };

        new Thread(t1).start();

        // After
        new Thread(() -> {
            System.out.println("Thread 2");
            System.out.println("Thread 2.1");
        }).start();
    }
}
