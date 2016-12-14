package com.eshop.controllers;


import com.eshop.model.Category;
import com.eshop.model.Item;
import com.eshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/categories/{categoryName}/items", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getAllItemsByCategory(@RequestParam String categoryName) {
        return categoryService.getItemsByCategoryName(categoryName);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();

    }
}
