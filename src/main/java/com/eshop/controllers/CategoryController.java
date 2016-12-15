package com.eshop.controllers;


import com.eshop.model.Category;
import com.eshop.model.Item;
import com.eshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/{categoryId}/items", method = RequestMethod.GET)
    public List<Item> getAllItemsByCategory(@PathVariable("categoryId") Long categoryId) {
        return categoryService.getItemsByCategoryId(categoryId);
    }

}
