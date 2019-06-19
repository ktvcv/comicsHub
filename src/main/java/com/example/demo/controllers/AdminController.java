package com.example.demo.controllers;


import com.example.demo.entities.*;
import com.example.demo.repos.ComicRepo;
import com.example.demo.repos.CommentRepo;
import com.example.demo.repos.LikesRepo;
import com.example.demo.service.ComicService;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//действия доступны лишь админу
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    ComicRepo comicRepo;

    @Autowired
    LikesRepo likesRepo;
    @Autowired
    FileService fileService;

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ComicService comicService;


    @Value("${upload.path}")
    private String uploadPath;


    @GetMapping("/comics")
    public String comicList(Model model) {
        Iterable<Comic> comics = comicRepo.findAll();
        model.addAttribute("comics", comics);
        return "comicList";
    }

    @PostMapping("/addComics")
    public String addComic(
                         @RequestParam String title,
                           @RequestParam String publisher,
                           @RequestParam String mark1,
                         @RequestParam String mark3,
                         @RequestParam String mark2,
                           @RequestParam("file1") MultipartFile file1,
                           @RequestParam("file2") MultipartFile file2,
                           @RequestParam("file3") MultipartFile file3
    )throws IOException
    {
        comicService.saveComics(title,publisher,file1,file2,file3,mark1,mark2,mark3);

        return "redirect:/";
    }
    @GetMapping("/addComics")
    public String addC()
    {
        return "addComics";
    }

    @GetMapping("/comics/{comic}")
    public String userEditForm(@PathVariable Comic comic, Model model) {
        model.addAttribute("comic", comic);
        return "editComic";
    }

    @PostMapping("/comics")
    public String comicSave(//редактирование комикса
            @RequestParam String title,
            @RequestParam String publisher,
            @RequestParam String artist,
            @RequestParam String screenwriter,
            @RequestParam String year,
            @RequestParam String description,
            @RequestParam("comicId") Comic comic,
            @RequestParam String hyperlinkRu,
            @RequestParam String hyperlinkEng
    ){
        comic.setTitle(title);
        comic.setPublisher(publisher);
        comic.setYear(year);
        comic.setArtist(artist);
        comic.setScreenwriter(screenwriter);
        comic.setDescription(description);
        comic.setHyperlinkRu(hyperlinkRu);
        comic.setHyperlinkEng(hyperlinkEng);
        comicRepo.save(comic);

        return "redirect:/admin/comics";
    }

    @PostMapping("/comics/{comic}/delete")
    public String deleteUser(@PathVariable Comic comic){
        comicService.deleteComics(comic);
        return "redirect:/admin/comics";
    }
    @GetMapping("/comics/{comic}/delete")
    public String delUser(@PathVariable Comic comic){
        comicService.deleteComics(comic);
        return "redirect:/admin/comics";
    }

}
