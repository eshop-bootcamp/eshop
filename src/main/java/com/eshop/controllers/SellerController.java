package com.eshop.controllers;

import com.eshop.model.Item;
import com.eshop.model.Category;
import com.eshop.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by akshaybansod on 12/13/16.
 */
@RestController
@RequestMapping(value = "/seller")
public class SellerController {


    private SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {

        this.sellerService = sellerService;
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Item addItemToCatelog(@RequestParam(name = "item-name", required = true) String itemName
            , @RequestParam(name = "category-id", required = true) Long categoryId
            , @RequestParam(name = "description", required = true) String description
            , @RequestParam(name = "quantity", required = true) double quantity
            , @RequestParam(name = "price", required = true) double price
            , @RequestParam(name = "image-url", required = true) String imageUrl) {
        Item item = sellerService.addItem(new Item(itemName, new Category(categoryId), description, quantity, price,
                imageUrl));
        return item;
    }


}
