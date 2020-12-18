package com.worstbuy.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Poster")
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;
    private String description;
    private String condition;
    private String category;
    private String tag;
    private String brand;
    private Date modifyDate;
    private Date createDate;
    private boolean isClose;

    private boolean hasImage;

    @ManyToOne
    @JoinTable(name = "user_poster",
    joinColumns = {@JoinColumn(name="user_id")},
    inverseJoinColumns = {@JoinColumn(name = "poster_id")})
    private User seller;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    //    public User getSeller() {
//        return seller;
//    }
//
//    public void setSeller(User seller) {
//        this.seller = seller;
//    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isClose() {
        return isClose;
    }

    public void setClose(boolean close) {
        isClose = close;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "id=" + id +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", condition='" + condition + '\'' +
                ", category='" + category + '\'' +
                ", tag='" + tag + '\'' +
                ", brand='" + brand + '\'' +
                ", modifyDate=" + modifyDate +
                ", createDate=" + createDate +
                ", isClose=" + isClose +
                '}';
    }
}
