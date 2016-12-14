package com.eshop.services;

import com.eshop.services.implementation.FileHandlerServiceImpl;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by srividhya on 13/12/16.
 */
public class FileHandlerServiceTest {

    FileHandlerService fileHandlerService = new FileHandlerServiceImpl();

    @Test
    public void givenANonExistentFileAndPathShouldSaveAndReturnURL(){
        MockMultipartFile multipartFile =
               new MockMultipartFile("file", "test"+ Math.random()+".png", "text/plain", "Spring Framework".getBytes());
        Path path = Paths.get("/Users/srividhya/Desktop/ItemImages");
       String url = fileHandlerService.handleFileUpload(multipartFile,path);
        assertEquals(path.toString() + "/" + multipartFile.getOriginalFilename(), url);
        assertTrue(new File(url).exists());
    }

    @Test
    public void givenAlreadyExistingFileShouldReturnMessage(){
        MockMultipartFile multipartFile =
                new MockMultipartFile("file", "test2.png", "text/plain", "Spring Framework".getBytes());
        Path path = Paths.get("/Users/srividhya/Desktop/ItemImages");
        String url = fileHandlerService.handleFileUpload(multipartFile,path);
        assertEquals("alreadyExists",url);
    }

}
