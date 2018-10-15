package com.example.springboot.controller;

import com.example.springboot.models.Item;
import com.example.springboot.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/all")
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable("id") String id) {
        return itemRepository.findOne(id);
    }

    @PostMapping()
    public Item addItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable("id") String id,
                       @RequestBody Item item) {
        Item item1 = itemRepository.findOne(id);
        if(item.getBy() != null) {
            item1.setBy(item.getBy());
        }
        if(item.getKids() != null) {
            item1.setKids(item.getKids());
        }
        if(item.getParent() != null) {
            item1.setParent(item.getParent());
        }
        if(item.getScore()!= null) {
            item1.setScore(item.getScore());
        }
        if(item.getParts() != null) {
            item.setParts(item1.getParts());
        }
        if(item.getText() != null) {
            item1.setText(item.getText());
        }
        if(item.getTime() != null) {
            item1.setTime(item.getTime());
        }
        if(item.getTitle() != null) {
            item1.setTitle(item.getTitle());
        }
        if(item.getType()!=null) {
            item1.setType(item.getType());
        }

        return itemRepository.save(item1);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String  id) {
        itemRepository.delete(id);
        return "deleted item with id" + id;
    }

}
