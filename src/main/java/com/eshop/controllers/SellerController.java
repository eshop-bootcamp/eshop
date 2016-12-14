package com.eshop.controllers;

import com.eshop.model.Item;
import com.eshop.model.Category;
import com.eshop.services.FileHandlerService;
import com.eshop.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by akshaybansod on 12/13/16.
 */
@RestController
@RequestMapping(value = "/seller")
public class SellerController {


    private SellerService sellerService;
    @Autowired
    @Qualifier("fileHandlerServiceImpl")
    private FileHandlerService fileHandlerService;

    @Autowired
    public SellerController(SellerService sellerService, FileHandlerService fileHandlerService) {
        this.fileHandlerService = fileHandlerService;
        this.sellerService = sellerService;
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Item addItemToCatelog(@RequestParam(name = "item-name", required = true) String itemName
            , @RequestParam(name = "category-id", required = true) Long categoryId
            , @RequestParam(name = "description", required = true) String description
            , @RequestParam(name = "quantity", required = true) double quantity
            , @RequestParam(name = "price", required = true) double price
            ,@RequestParam("file") MultipartFile file) {
        Path path = Paths.get("./src/main/resources/ItemImages");
        String imageUrl = fileHandlerService.handleFileUpload(file,path);
        Item item = null;
        if(!"error".equalsIgnoreCase(imageUrl)){
        item = sellerService.addItem(new Item(itemName, new Category(categoryId), description, quantity, price,
                imageUrl));
        } else{
            item = sellerService.addItem(new Item(itemName, new Category(categoryId), description, quantity, price,
                    ""));
        }
        return item;
    }


}
