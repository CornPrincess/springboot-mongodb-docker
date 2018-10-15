package com.example.springboot.models;

/**
 * @author corn
 * @version 1.0.0
 */
public class Address {

    private String city;
    private String country;

    protected Address() {

    }

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
