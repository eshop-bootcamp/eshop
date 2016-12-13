package com.eshop.repositories;

import com.eshop.models.Category;
import com.eshop.models.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by akshaybansod on 12/13/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testSaveItem(){
        Item savedItem = itemRepository.save(new Item("Samsung mobile", new Category(1L), "phone", 1, 1000, ""));
        assertNotNull(savedItem.getId());
    }



}