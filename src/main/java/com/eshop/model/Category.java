package com.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by sappana on 12/12/2016.
 */
@Entity
public class Category {

    private
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String name;

    public Category() {}

    public Category(Long categoryId) {
        id = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
