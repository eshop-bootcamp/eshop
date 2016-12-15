package com.eshop.integration;

import com.eshop.model.Category;
import com.eshop.model.Item;
import com.eshop.repositories.CategoryRepository;
import com.eshop.repositories.ItemRepository;
import com.google.common.collect.Iterables;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testGetCategories() {
        Iterable<Category> categories = categoryRepository.findAll();

        assertNotNull(categories);
        assertTrue(Iterables.size(categories)>0);
    }

    @Test
    public void shouldGetItemsByCategoryId() {
        itemRepository.deleteAll();
        List<Item> items = Arrays.asList(itemRepository.save(new Item("Samsung mobile", new Category(1L), "phone", 1, 1000, "")),
        itemRepository.save(new Item("Nokia mobile", new Category(1L), "sturdy phone", 1, 1002, "")));

        Category category = categoryRepository.findOne(1l);
        List<Item> actualItems = category.getItems();
        assertFalse(actualItems.isEmpty());
        //assertEquals(2, actualItems.size());
        //assertEquals(items, actualItems);
    }

}
