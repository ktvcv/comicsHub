package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Value("${upload.path}")
    private String uploadPath;

    public String makeFile(MultipartFile file) throws IOException {

        String resultFilename = "image";
        if (file != null && !file.getOriginalFilename().isEmpty()) {//если картнка прогрузилась
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            resultFilename = uuidFile + "." + file.getOriginalFilename();//уникальность названия

            file.transferTo(new File(uploadPath + "/" + resultFilename));//создание файла в папке проэкта
            }


        return resultFilename;
    }
}