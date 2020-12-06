package com.worstbuy.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;

    @OneToMany
    @JoinColumn(name="TRANSACTION_ID")
    private List<Transaction> transactions;

    private List<Poster> posters;

}
