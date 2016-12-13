package com.eshop.controllers;

import com.eshop.model.Category;
import com.eshop.services.CategoryService;
import com.eshop.services.implementation.BuyerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


/**
 * Created by srividhya on 13/12/16.
 */
public class BuyerControllerTest {

    BuyerController mockBuyerController;

    @Mock
    View mockView;

    MockMvc mockMvc;

    CategoryService mockCategoryService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockCategoryService = Mockito.mock(BuyerServiceImpl.class);
        mockBuyerController = new BuyerController(mockCategoryService);
        mockMvc = standaloneSetup(mockBuyerController)
                .setSingleView(mockView)
                .build();
    }

    @Test
    public void testForGivenCategoryUrlShouldFetchAllCategories() throws Exception {
        Category categoryA = new Category();
        categoryA.setId(1L);
        categoryA.setName("Electronics");


        List<Category> expectedCategories = asList(categoryA);
        when(mockCategoryService.fetchAllCategories()).thenReturn(expectedCategories);


        mockMvc.perform(get("/category/getcategories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

}
