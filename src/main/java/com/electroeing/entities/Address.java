package com.electroeing.entities;

public class Address {
    private String block;
    private String city;
    private String state;
    private String country;
    int pinCode;

    public Address() {
    }

    public Address(String block, String city, String state, String country, int pinCode) {
        super();
        this.block = block;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "block='" + block + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }

    public String getBlock() {
        return block;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getPinCode() {
        return pinCode;
    }
}

