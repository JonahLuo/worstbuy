package com.worstbuy.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

//    @OneToOne
//    @JoinColumn(name = "poster_id")
//    private Poster poster;

    @ManyToOne
    private User buyer;

    @ManyToOne
    private User seller;

    private String status;

//    public Poster getPoster() {
//        return poster;
//    }
//
//    public void setPoster(Poster poster) {
//        this.poster = poster;
//    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    private double rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", status='" + status + '\'' +
                ", rate=" + rate +
                '}';
    }
}
