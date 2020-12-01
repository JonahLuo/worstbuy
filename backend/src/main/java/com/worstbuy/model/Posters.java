package com.worstbuy.model;

import java.util.Date;

public class Posters {

    private int id;
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
