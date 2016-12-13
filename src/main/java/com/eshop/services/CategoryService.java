package com.eshop.services;

import com.eshop.model.Category;

import java.util.List;

/**
 * Created by srividhya on 13/12/16.
 */
public interface CategoryService {
    public List<Category> fetchAllCategories();
}
