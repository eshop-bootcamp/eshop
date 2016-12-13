package com.eshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by sappana on 12/12/2016.
 */
@Entity
public class Category {

    private @Id @GeneratedValue Long id;

    private Category() {}


}
