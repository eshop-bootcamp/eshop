package com.eshop.services;

import com.eshop.model.Category;
import com.eshop.model.Item;
import com.eshop.repositories.CategoryRepository;
import com.eshop.repositories.ItemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void testDataIsFetchedSuccessfullyFromService() {
        when(categoryRepository.findAll()).thenReturn(new ArrayList<Category>());
        List<Category> allCategories = categoryService.getAllCategories();
        verify(categoryRepository).findAll();
        Assert.assertNotNull(allCategories);
    }

    @Test
    public void categoryServiceShouldBeAbleToReturnAllItemsInACategory() {
        Category category = new Category();
        category.setItems(new ArrayList<Item>());
        when(categoryRepository.findOne(1l)).thenReturn(category);
        List<Item> items = categoryService.getItemsByCategoryId(1l);
        verify(categoryRepository).findOne(1l);
        Assert.assertNotNull(items);
    }

}
