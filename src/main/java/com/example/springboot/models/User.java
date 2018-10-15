package com.example.springboot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String about;
    private Integer created;
    private Integer delay;
    private Integer karma;
    private List<Integer> submitted;

    public User() {
    }

    public User(String id, String about, Integer created, Integer delay, Integer karma, List<Integer> submitted) {
        this.id = id;
        this.about = about;
        this.created = created;
        this.delay = delay;
        this.karma = karma;
        this.submitted = submitted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Integer getKarma() {
        return karma;
    }

    public void setKarma(Integer karma) {
        this.karma = karma;
    }

    public List<Integer> getSubmitted() {
        return submitted;
    }

    public void setSubmitted(List<Integer> submitted) {
        this.submitted = submitted;
    }
}
