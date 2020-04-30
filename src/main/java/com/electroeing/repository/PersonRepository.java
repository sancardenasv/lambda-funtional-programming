package com.electroeing.repository;

import com.electroeing.entities.Address;
import com.electroeing.entities.Person;
import java.util.Arrays;
import java.util.List;

public class PersonRepository {

    private PersonRepository() {
    }

    public static List<Person> getAllPersons() {
        Person p1 = new Person("John", 165, 2000, Gender.MALE.getGenderName(), 2, Arrays.asList("Cricket", "Swimming", "Tennis"));
        Person p2 = new Person("Angel", 158, 5000, Gender.FEMALE.getGenderName(), 2, Arrays.asList("Driving", "Music", "Football"));
        Person p3 = new Person("Dean", 140, 5700, Gender.MALE.getGenderName(), 2, Arrays.asList("Cricket", "Driving", "Tennis"));
        Person p4 = new Person("Nancy", 130, 4900, Gender.FEMALE.getGenderName(), 2, Arrays.asList("Cricket", "Swimming", "Tennis"));
        Person p5 = new Person("Harper", 125, 9000, Gender.FEMALE.getGenderName(), 2, Arrays.asList("Football", "Swimming", "Tennis"));
        Person p6 = new Person("Alan", 110, 9000, Gender.MALE.getGenderName(), 2, Arrays.asList("Cricket", "Swimming", "Tennis"));
        Person p7 = new Person("Campell", 165, 1548, Gender.MALE.getGenderName(), 1, Arrays.asList("Swimming", "Tennis"));

        return Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
    }

    public static Person getPerson() {
        final Address address = new Address("7th block", "Bogota", "Cundinamarca", "Colombia", 123456);
        final Person person = new Person("John", 165, 2000, Gender.MALE.getGenderName(), 2,
                Arrays.asList("Cricket", "Swimming", "Tennis"));
        person.setAddress(address);
        return person;
    }

    private enum Gender {
        MALE("Male"),
        FEMALE("Female");

        private String genderName;

        Gender(String genderName) {
            this.genderName = genderName;
        }

        public String getGenderName() {
            return genderName;
        }
    }

}
