package com.electroeing.entities;

import java.util.List;
import java.util.Optional;

public class Person {
    private String name;
    private int height;
    private double salary;
    private String gender;
    private int kids;
    private List<String> hobbies;
    private Address address;

    public Person() {
    }

    public Person(String name, int height, double salary, String gender, int kids, List<String> hobbies) {
        this.name = name;
        this.height = height;
        this.salary = salary;
        this.gender = gender;
        this.kids = kids;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", kids=" + kids +
                ", hobbies=" + hobbies +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public int getKids() {
        return kids;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
