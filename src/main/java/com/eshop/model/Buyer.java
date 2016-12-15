package com.eshop.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by sappana on 13/12/2016.
 */
@Entity
@DiscriminatorValue(value = "Buyer")
public class Buyer extends User {
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Buyer(String username, String password, Gender gender) {
        super(username, password);
        this.gender = gender;
    }
}
