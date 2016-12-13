package com.eshop.controllers;

import com.eshop.models.Category;
import com.eshop.models.Item;
import com.eshop.services.SellerService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by akshaybansod on 12/13/16.
 */
public class SellerControllerTest {


    private SellerController sellerController;
    private SellerService sellerServiceMock;

    @Before
    public void setUp() throws Exception {
        sellerServiceMock = mock(SellerService.class);
        sellerController = new SellerController(sellerServiceMock);
    }

    @Test
    public void testAddItemToCatelog() throws Exception {
        Item item = new Item("Samsung", new Category(1L), "samsung phone", 1, 1000, "");
        when(sellerServiceMock.addItem(anyObject())).thenReturn(item);
        Item savedItem = sellerController.addItemToCatelog("Samsung", 1l, "samsung phone", 1, 1000,"");
        assertNotNull(savedItem);
    }

}