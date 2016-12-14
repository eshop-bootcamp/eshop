package com.eshop.services.implementation;

import com.eshop.model.Category;
import com.eshop.repositories.CategoryRepository;
import com.eshop.services.CategoryService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by srividhya on 13/12/16.
 */
@Service
public class BuyerServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> fetchAllCategories() {
        return Lists.newArrayList(categoryRepository.findAll());
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

}
