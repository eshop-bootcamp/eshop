package com.eshop.services;

import com.eshop.model.Category;
import com.eshop.model.Item;
import com.eshop.repositories.CategoryRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by srividhya on 13/12/16.
 */
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return Lists.newArrayList(categoryRepository.findAll());
    }

    public List<Item> getItemsByCategoryName(String categoryName) {
        return null;
    }

}
