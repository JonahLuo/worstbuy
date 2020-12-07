package com.worstbuy.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Posters")
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String description;

    //TODO: make condition, category, tag, and brand as enum if possible. Model class and Database could be created if necessary
    private String condition;
    private String category;
    private String tag;
    private String brand;
    private Date modifyDate;
    private Date createDate;
    private boolean isClose;


}
