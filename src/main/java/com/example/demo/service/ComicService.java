package com.example.demo.service;

import com.example.demo.entities.Comic;
import com.example.demo.entities.Likes;
import com.example.demo.repos.ComicRepo;
import com.example.demo.repos.LikesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ComicService {

    @Autowired
    ComicRepo comicRepo;
    @Autowired
    LikesRepo likesRepo;
    @Autowired
    FileService fileService;

    public void saveComics(String title, String publisher, MultipartFile file1,
                           MultipartFile file2, MultipartFile file3, String mark1, String mark2, String mark3)
        throws IOException{


        Comic comic = new Comic(title, publisher);

        comic.setFilename1(fileService.makeFile(file1));
        comic.setFilename2(fileService.makeFile(file2));
        comic.setFilename3(fileService.makeFile(file3));

        Likes likes = new Likes(mark2, mark1, mark3);
        likesRepo.save(likes);
        comic.setLikes(likes);
        comicRepo.save(comic);
    }

    public void deleteComics(Comic comic){

        comicRepo.delete(comic);

    }
}