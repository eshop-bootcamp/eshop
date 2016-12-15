package com.eshop.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by sappana on 13/12/2016.
 */
@Entity
@DiscriminatorValue(value = "Buyer")
public class Buyer extends User {

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    public Buyer(String username, String password) {
        super(username, password);
    }
    public Buyer(){

    }
}
