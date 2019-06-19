package com.example.demo.controllers;

import com.example.demo.entities.Comic;
import com.example.demo.entities.Comment;
import com.example.demo.entities.Favourite;
import com.example.demo.entities.User;
import com.example.demo.repos.ComicRepo;
import com.example.demo.repos.CommentRepo;
import com.example.demo.repos.FavRepo;
import com.example.demo.service.UserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class ComicsController {

    @Autowired
    private ComicRepo comicRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private UserService userService;

    @Autowired
    FavRepo favRepo;

    @GetMapping("/")//отображение всех комиксов
    public String main(Map<String, Object> model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                       @RequestParam(required = false, defaultValue = "") String filter ) {


        Page<Comic> page;
        if (filter != null && !filter.isEmpty()) {
           page= comicRepo.findByPublisher(filter,pageable);
        } else {
            page= comicRepo.findAll(pageable);
        }
        Iterable<Comic> comics = comicRepo.findAll();
        model.put("page", page);
        model.put("url", "/");
        model.put("filter",filter);

        return "main";
    }


    @PostMapping("/")
    public String main1(Map<String, Object> model, Pageable pageable) {
        Page<Comic> page = comicRepo.findAll(pageable);
        Iterable<Comic> comics = comicRepo.findAll();
        model.put("page", page);
        model.put("url", "/");

        return "main";
    }


    @GetMapping("main/comics/{comic}")
    public String userEditForm(@PathVariable Comic comic, Model model) {
        model.addAttribute("comic", comic);
        Set<Comment> comments = commentRepo.findCommentByComicId(comic.getId());
        model.addAttribute("comments",comments);
        return "detailComic";}

    @PostMapping("main/comics/")
    public String addComment(
            @RequestParam("c_id") Long id,
            @AuthenticationPrincipal User user,
            @RequestParam String text1
    ){
        Comic comic = comicRepo.getById(id);
        Comment comment = new Comment();
        comment.setComic(comic);
        comment.setText(text1);
        comment.setAuthor(user);
        commentRepo.save(comment);
        return "redirect:/main/comics/" + id;

    }


    @PostMapping("addToFav")//добавление комиксов в избранное
    public String addToFav(
            @RequestParam("c_id") Long id,
            @AuthenticationPrincipal User user
    )
    {
        Favourite favourite = new Favourite(user,comicRepo.getById(id));
        List<Favourite> favRepoAllByAuthor = favRepo.findAllByAuthor(user);
        for (Favourite i:favRepoAllByAuthor) {
            if ((i.getComic().getId().equals(favourite.getComic().getId()))) {
                return "redirect:/";
            }
            else
                favRepo.save(favourite);
        }

        return"redirect:/";

    }
    @PostMapping("/main/comics/{comic}/{comment}/deleteComment")
    public String deleteUser(@PathVariable Comic comic, @PathVariable Comment comment){
        commentRepo.delete(comment);
        return "redirect:/main/comics/{comic}";
    }
    @GetMapping("/main/comics/{comic}/{comment}/deleteComment")
    public String delUser(@PathVariable Comic comic, @PathVariable Comment comment){
        commentRepo.delete(comment);
        return "redirect:/main/comics/{comic}";
    }

    @GetMapping("/news")
    public String news(){
        return "news";
    }
}