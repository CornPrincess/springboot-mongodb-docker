package com.example.springboot.controller;

import com.example.springboot.models.Hotel;
import com.example.springboot.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author corn
 * @version 1.0.0
 */

@RestController
@RequestMapping("/rest/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;


    @GetMapping("/all")
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @PutMapping("/{id}")
    public Hotel insert(@PathVariable("id") String id,
                       @RequestBody Hotel hotel) {
        Hotel hotel1 = hotelRepository.findById(id);
        if(hotel.getAddress() != null) {
            hotel1.setAddress(hotel.getAddress());
        }
        if(hotel.getName() != null) {
            hotel1.setName(hotel.getName());
        }
        if(hotel.getPricePerNight() != null) {
            hotel1.setPricePerNight(hotel.getPricePerNight());
        }
        if(hotel.getReviews() != null) {
            hotel1.setReviews(hotel.getReviews());
        }

        return hotelRepository.save(hotel);
    }

    @PostMapping
    public Hotel update(@RequestBody Hotel hotel) {
        return hotelRepository.insert(hotel);
    }

    //1.对于数据库中没有改字段，两者没有区别
    //2.对于数据库中有该字段，insert会报错，save会执行更新操作
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        hotelRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id) {
        return  hotelRepository.findById(id);
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice) {
        return hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city) {
        List<Hotel> hotels = hotelRepository.findByCity(city);
        return hotels;
    }

    @GetMapping("/address/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country) {
        List<Hotel> hotels = hotelRepository.findByCountry(country);
        return hotels;
    }

}
