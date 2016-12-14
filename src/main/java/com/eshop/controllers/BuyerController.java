package com.eshop.controllers;

import com.eshop.model.Category;
import com.eshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by srividhya on 13/12/16.
 */
@RestController
@RequestMapping("/category")
public class BuyerController {

    @Autowired
    @Resource(name = "buyerServiceImpl")
    CategoryService buyerService;


    BuyerController(CategoryService categoryService) {
        buyerService = categoryService;
    }




}
