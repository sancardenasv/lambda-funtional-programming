package com.electroeing.streams.parallel;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SequentialParallelExample {
    private static final Logger log = LogManager.getLogger(SequentialParallelExample.class);

    public static void main(String[] args) {
        String[] str = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        log.info("Serial Printing Started");
        printStream(Stream.of(str));
        log.info("Serial Printing Ended");
        log.info("Parallel Printing Started");
        printStream(Stream.of(str).parallel());
        log.info("Parallel Printing Ended");

        log.info("Sequential list count: {}", getHobbiesSequential().size());
        log.info("Parallel list count: {}", getHobbiesParallel().size());

        log.info("When not to use");
        Calculation calculation = new Calculation();
        IntStream.rangeClosed(0, 2000).forEach(calculation::calculate);
        log.info("Result in sequence: {}", calculation.getTotal());
        calculation = new Calculation();
        IntStream.rangeClosed(0, 2000).parallel().forEach(calculation::calculate);
        log.info("Result in parallel: {}", calculation.getTotal());

    }

    private static void printStream(Stream<String> stream) {
        stream.forEach(s -> {
            log.info("Printing value: {}", s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Sleep error", e);
                Thread.currentThread().interrupt();
            }
        });
    }

    private static List<String> getHobbiesSequential() {
        Calendar cal = Calendar.getInstance();
        final long start = cal.getTimeInMillis();
        final List<String> collect = PersonRepository.getAllPersons().stream()
                .map(Person::getHobbies)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        cal = Calendar.getInstance();
        final long duration = cal.getTimeInMillis() - start;
        log.info("Sequential duration: {}", duration);
        return collect;
    }

    private static List<String> getHobbiesParallel() {
        Calendar cal = Calendar.getInstance();
        final long start = cal.getTimeInMillis();
        final List<String> collect = PersonRepository.getAllPersons().stream().parallel()
                .map(Person::getHobbies)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        cal = Calendar.getInstance();
        final long duration = cal.getTimeInMillis() - start;
        log.info("Parallel duration: {}", duration);
        return collect;
    }

}

class Calculation {
    private int total;

    public void calculate(int n) {
        total += n;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
