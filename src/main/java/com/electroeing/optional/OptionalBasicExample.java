package com.electroeing.optional;

import com.electroeing.entities.Person;
import com.electroeing.repository.PersonRepository;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OptionalBasicExample {
    private static final Logger log = LogManager.getLogger(OptionalBasicExample.class);

    public static void main(String[] args) {
        final String name = myName("Mike");
        log.info("Simple method call: {}", name);
        final Optional<String> nameOptional = Optional.of(name);
        log.info("Result with Optional: {}", nameOptional);

        final Optional<String> myNameOpt = Optional.ofNullable(myName(null));
        log.info("Result with Optional null: {}", myNameOpt.isPresent() ? myNameOpt.get() : "no value");
        log.info("Result with Optional null: {}", nameOptional.isPresent() ? nameOptional.get() : "no value");

        log.info("getPersonName method result: {}", getPersonName(new Person()));
        log.info("getPersonNameOpt method with null result: {}", getPersonNameOpt(null));
        log.info("getPersonNameOpt method with new obj result: {}", getPersonNameOpt(new Person()));
        log.info("getPersonNameOpt method with person obj result: {}",
                getPersonNameOpt(PersonRepository.getPerson()));

    }

    private static String myName(String name) {
        return name;
    }

    private static String getPersonName(Person person) {
        if (person != null) {
            return person.getName();
        }
        return "No name found!";
    }

    private static Optional<String> getPersonNameOpt(Person person) {
        return Optional.ofNullable(person).map(Person::getName);
    }
}
