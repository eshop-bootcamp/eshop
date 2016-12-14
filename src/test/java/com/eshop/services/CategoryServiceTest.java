package com.eshop.services;

import com.eshop.model.Category;
import com.eshop.repositories.CategoryRepository;
import com.eshop.services.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.mockito.Mockito.when;


public class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Test
    public void testDataIsFetchedSuccessfullyFromService() {
        CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);
        when(categoryRepository.findAll()).thenReturn(new ArrayList<Category>());
        Assert.assertTrue(categoryService.getAllCategories() != null);
    }

}
