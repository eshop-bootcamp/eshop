package com.eshop.integration;

/**
 * Created by srividhya on 14/12/16.
 */
import com.eshop.model.Category;
import com.eshop.repositories.CategoryRepository;
import com.google.common.collect.Iterables;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by sappana on 12/12/2016.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void testGetCategories() {
        Iterable<Category> categories = categoryRepository.findAll();

        assertNotNull(categories);
        assertTrue(Iterables.size(categories)>0);
    }
}
