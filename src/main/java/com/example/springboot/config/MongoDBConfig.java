package com.example.springboot.config;

import com.example.springboot.models.Address;
import com.example.springboot.models.Hotel;
import com.example.springboot.models.Review;
import com.example.springboot.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author corn
 * @version 1.0.0
 */

@EnableMongoRepositories(basePackageClasses = HotelRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(HotelRepository hotelRepository) {

        return  new CommandLineRunner() {

            @Override
            public void run(String... strings) throws Exception {
                Hotel marriot = new Hotel(
                        "Marriot",
                        130,
                        new Address("Paris", "France"),
                        Arrays.asList(
                                new Review("John", 8, false),
                                new Review("Mary", 7, true)
                        )
                );

                Hotel ibis = new Hotel(
                        "Ibis",
                        90,
                        new Address("Bucharest", "Romania"),
                        Arrays.asList(
                                new Review("Teddy", 9, true)
                        )
                );

                Hotel sofitel = new Hotel(
                        "Sofitel",
                        200,
                        new Address("Rome", "Italy"),
                        new ArrayList<>()
                );

                // drop all hotels
                hotelRepository.deleteAll();

                //add our hotels to the database
                List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
                hotelRepository.save(hotels);
            }
        };
    }
}
