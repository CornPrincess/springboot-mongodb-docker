package com.example.springboot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "items")
public class Item {
    @Id
    private String _id;
    private Integer id;
    private String by;
    private List<Integer> kids;
    private Integer parent;
    private List<Integer> parts;
    private Integer score;
    private String title;
    private String text;
    private Long time;
    private String type;
    private String url;

    public Item() {
    }

    public Item(Integer id, String by, List<Integer> kids, Integer parent, List<Integer> parts, Integer score, String title, String text, Long time, String type, String url) {
        this.id = id;
        this.by = by;
        this.kids = kids;
        this.parent = parent;
        this.parts = parts;
        this.score = score;
        this.title = title;
        this.text = text;
        this.time = time;
        this.type = type;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public List<Integer> getKids() {
        return kids;
    }

    public void setKids(List<Integer> kids) {
        this.kids = kids;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public List<Integer> getParts() {
        return parts;
    }

    public void setParts(List<Integer> parts) {
        this.parts = parts;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
