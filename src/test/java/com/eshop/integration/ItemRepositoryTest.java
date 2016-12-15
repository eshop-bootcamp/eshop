package com.eshop.integration;

import com.eshop.model.Category;
import com.eshop.model.Item;
import com.eshop.repositories.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
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
