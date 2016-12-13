package com.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    private @Id @GeneratedValue Long id;

    private String username;
    private String password;
    private String emailId;

     public User(){

     }

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }


    public String getEmailId() {
        return emailId;
    }

    public String getUsername() {
        return username;
    }
}
