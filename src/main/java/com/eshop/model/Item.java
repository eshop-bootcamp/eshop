package com.eshop.model;


import javax.persistence.*;

/**
 * Created by akshaybansod on 12/12/16.
 */
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    private Category category;
    private String description;
    private double quantity;
    private double price;
    private String imagePath;


    public Item(String name, Category category, String description, double quantity, double price, String imagePath) {

        this.name = name;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.imagePath = imagePath;
    }

    public Long getId(){
        return this.id;
    }


}
