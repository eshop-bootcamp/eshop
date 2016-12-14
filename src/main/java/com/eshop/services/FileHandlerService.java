package com.eshop.services;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

/**
 * Created by srividhya on 13/12/16.
 */
public interface FileHandlerService {
    public String handleFileUpload(MultipartFile file, Path path);
}
