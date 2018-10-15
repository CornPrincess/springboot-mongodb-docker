package com.example.springboot.repository;

import com.example.springboot.models.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author corn
 * @version 1.0.0
 */

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>{

    Hotel findById(String id);

    List<Hotel> findByPricePerNightLessThan(int maxPrice);

    //  @Query("{ 'firstname' : ?0 }")
    @Query("{ 'address.city' : ?0 }")
    List<Hotel> findByCity(String city);

    @Query("{ 'address.country' : ?0 }")
    List<Hotel> findByCountry(String country);
}
