package com.electroeing.entities;

import java.util.List;

public class Person {
    private String name;
    private int height;
    private double salary;
    private String gender;
    private int kids;
    List<String> hobbies;

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
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", height=").append(height);
        sb.append(", salary=").append(salary);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", kids=").append(kids);
        sb.append(", hobbies=").append(hobbies);
        sb.append('}');
        return sb.toString();
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

}
