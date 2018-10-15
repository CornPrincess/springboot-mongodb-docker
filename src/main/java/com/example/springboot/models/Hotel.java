package com.example.springboot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author corn
 * @version 1.0.0
 */

@Document(collection = "hotels")
public class Hotel {
    @Id
    private String id;
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private Integer pricePerNight;
    private Address address;
    private List<Review> reviews;

    protected Hotel(){

    }

    public Hotel(String name, Integer pricePerNight, Address address, List<Review> reviews) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.address = address;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public Address getAddress() {
        return address;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPricePerNight(Integer pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
