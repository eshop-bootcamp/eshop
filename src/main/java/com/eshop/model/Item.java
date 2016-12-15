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
    @JoinColumn(name = "category_id")
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
    public Item() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Double.compare(item.quantity, quantity) != 0) return false;
        if (Double.compare(item.price, price) != 0) return false;
        if (!name.equals(item.name)) return false;
        if (!category.equals(item.category)) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        return imagePath != null ? imagePath.equals(item.imagePath) : item.imagePath == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        return result;
    }

    public Long getId(){
        return this.id;
    }


}
