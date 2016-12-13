package com.eshop.services;

import com.eshop.models.Item;
import com.eshop.models.Category;
import com.eshop.repositories.ItemRepository;
import com.eshop.services.implementation.SellerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by akshaybansod on 12/12/16.
 */
public class SellerServiceTest {

    private SellerService sellerService;
    private ItemRepository itemRepository;

    @Before
    public void setUp() {
        itemRepository = mock(ItemRepository.class);
        sellerService = new SellerServiceImpl(itemRepository);
    }

    @Test
    public void testAddItemBySeller() {

        Category category = new Category(1L);
        Item item = new Item("iPhone 5s", category, "Its a mobile phone", 5.0d, 50000d, "Image Path");
        when(itemRepository.save(any(Item.class))).thenReturn(item);
        Item savedItem = sellerService.addItem(item);
        Assert.assertNotNull(savedItem);
    }
}
