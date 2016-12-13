package com.eshop.service;

import com.eshop.model.Category;
import com.eshop.repositories.CategoryRepository;
import com.eshop.services.CategoryService;
import com.eshop.services.implementation.BuyerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

/**
 * Created by srividhya on 13/12/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Test
    public void testDataIsFetchedSuccessfullyFromService() {
        BuyerServiceImpl buyerService = new BuyerServiceImpl();
        CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);
        buyerService.setCategoryRepository(categoryRepository);

        when(categoryRepository.findAll()).thenReturn(new ArrayList<Category>());

        Assert.assertTrue(buyerService.fetchAllCategories() != null);
    }

}
