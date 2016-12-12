package com.eshop.repositories;

import com.eshop.model.Category;
import com.google.common.collect.Iterables;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by sappana on 12/12/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void testGetCategories() {
        Iterable<Category> categories = categoryRepository.findAll();

        assertNotNull(categories);
        assertTrue(Iterables.size(categories)==2);
    }
}
