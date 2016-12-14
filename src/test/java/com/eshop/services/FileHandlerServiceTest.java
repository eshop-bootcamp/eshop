package com.eshop.services;

import com.eshop.services.implementation.FileHandlerServiceImpl;
import org.junit.After;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by srividhya on 13/12/16.
 */
public class FileHandlerServiceTest {

    FileHandlerService fileHandlerService = new FileHandlerServiceImpl();
    @Test
    public  void givenANonExistentDirectoryShouldCreateOne(){
        MockMultipartFile multipartFile =
                new MockMultipartFile("file", "test"+ Math.random()+".png", "text/plain", "Spring Framework".getBytes());
        String nonExistentUrl = "./src/test/resources/ItemImages"+Math.random();
        Path path = Paths.get(nonExistentUrl);
        String url = fileHandlerService.handleFileUpload(multipartFile,path);
        assertTrue(new File(nonExistentUrl).exists());
        assertTrue(new File(url).exists());
    }

    @Test
    public void givenANonExistentFileShouldSaveAndReturnURL(){
        MockMultipartFile multipartFile =
               new MockMultipartFile("file", "test"+ Math.random()+".png", "text/plain", "Spring Framework".getBytes());
        Path path = Paths.get("./src/test/resources/ItemImages");
       String url = fileHandlerService.handleFileUpload(multipartFile,path);
        assertEquals(path.toString() + "/" + multipartFile.getOriginalFilename(), url);
        assertTrue(new File(url).exists());
    }

    @Test
    public void givenAlreadyExistingFileShouldCreateNewFile(){
        MockMultipartFile multipartFile =
                new MockMultipartFile("file", "test2.png", "text/plain", "Spring Framework".getBytes());
        Path path = Paths.get("./src/test/resources/ItemImages");
        try {
            if (!Files.exists(path.resolve(multipartFile.getOriginalFilename()))) {
                Files.copy(multipartFile.getInputStream(), path.resolve(multipartFile.getOriginalFilename()));
            }
        } catch (IOException exception){

        }
        String url = fileHandlerService.handleFileUpload(multipartFile,path);
        assertTrue(new File(url).exists());
    }

    @After
    public void deleteFilesCreatedByTest(){
        File folder = new File("./src/test/resources");

            deleteFilesCreatedByTest(folder);
    }

    private void deleteFilesCreatedByTest(File dir) {
        if (dir.isDirectory())
        { File[] children = dir.listFiles();
        for (int i = 0; i < children.length; i++)
        {  deleteFilesCreatedByTest(children[i]);
        }
        }
        if(!dir.getPath().endsWith("resources"))
        dir.delete();


}



}
