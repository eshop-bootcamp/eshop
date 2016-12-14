package com.eshop.services.implementation;

import com.eshop.services.FileHandlerService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by srividhya on 13/12/16.
 */
@Service
public class FileHandlerServiceImpl implements FileHandlerService {
    @Override
    public String handleFileUpload(MultipartFile file, Path path) {
        try {
            if(!Files.exists(path.resolve(file.getOriginalFilename()))) {
                Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
            } else{
                return "alreadyExists";
            }
        } catch (IOException e) {
            return "error";
        }
        return path.toString()+"/"+file.getOriginalFilename();
    }
}

