package com.eshop.services.implementation;

import com.eshop.models.Item;
import com.eshop.repositories.ItemRepository;
import com.eshop.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akshaybansod on 12/12/16.
 */

@Service
public class SellerServiceImpl implements SellerService {


    private ItemRepository itemRepository;

    @Autowired
    public SellerServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }



    @Override
    public Item addItem(Item item) {
        Item savedItem = itemRepository.save(item);
        return savedItem;
    }

}
