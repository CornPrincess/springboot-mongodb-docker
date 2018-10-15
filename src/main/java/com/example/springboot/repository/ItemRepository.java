package com.example.springboot.repository;

import com.example.springboot.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
    Item findById(Integer id);
}
