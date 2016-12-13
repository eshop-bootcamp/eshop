package com.eshop.service;

import com.eshop.model.Category;
import com.eshop.repositories.CategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by srividhya on 13/12/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Test
    public void testDataIsFetchedSuccessfullyFromService() {
        CategoryService categoryService = new CategoryService();
        CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryService.setCategoryRepository(categoryRepository);

        when(categoryRepository.findAll()).thenReturn(new ArrayList<Category>());

        Assert.assertTrue(categoryService.fetchAllCategories() != null);
    }

}
