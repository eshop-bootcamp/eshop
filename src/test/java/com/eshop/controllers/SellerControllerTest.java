package com.eshop.controllers;

import com.eshop.model.Category;
import com.eshop.model.Item;
import com.eshop.services.FileHandlerService;
import com.eshop.services.SellerService;
import com.eshop.services.implementation.FileHandlerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by akshaybansod on 12/13/16.
 */

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SellerControllerTest {


    private SellerController sellerController;
    private SellerService sellerServiceMock;
    private FileHandlerService fileHandlerServiceMock;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        sellerServiceMock = mock(SellerService.class);
        fileHandlerServiceMock = mock(FileHandlerServiceImpl.class);
        sellerController = new SellerController(sellerServiceMock,fileHandlerServiceMock);
    }

    @Test
    public void testAddItemToCatelog() throws Exception {
       MockMultipartFile multipartFile =
                new MockMultipartFile("file", "test.png", "image/png", "Spring Framework".getBytes());
        String url = "/Users/srividhya/Desktop/ItemImages/test.png";

        when(fileHandlerServiceMock.handleFileUpload(anyObject(),anyObject())).thenReturn(url);
        Item item = new Item("Samsung", new Category(1L), "samsung phone", 1, 1000, url);
        when(sellerServiceMock.addItem(anyObject())).thenReturn(item);
        Item savedItem = sellerController.addItemToCatelog("Samsung", 1l, "samsung phone", 1, 1000,multipartFile);
        assertNotNull(savedItem);
    }


}