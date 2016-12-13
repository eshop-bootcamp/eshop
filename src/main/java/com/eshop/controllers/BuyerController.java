package com.eshop.controllers;

import com.eshop.model.Category;
import com.eshop.services.CategoryService;
import com.eshop.services.implementation.BuyerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by srividhya on 13/12/16.
 */
@RestController
@RequestMapping("/category")
public class BuyerController {

    @Autowired
            @Qualifier("BuyerServiceImpl")
    CategoryService buyerService;


    BuyerController(CategoryService categoryService) {
        buyerService = categoryService;
    }

    @RequestMapping(value = "/getcategories", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getAllCategories() {

        return buyerService.fetchAllCategories();

    }

}
