package com.example.demo.controllers;

import com.example.demo.entities.Comic;
import com.example.demo.entities.Favourite;
import com.example.demo.entities.User;
import com.example.demo.repos.ComicRepo;
import com.example.demo.repos.FavRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ComicRepo comicRepo;

    @Autowired
    FavRepo favRepo;


    @GetMapping("profile")//профиль пользователя
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        List<Favourite> favRepoAllByAuthor = favRepo.findAllByAuthor(user);
        model.addAttribute("favU",favRepoAllByAuthor);

        System.out.print(favRepoAllByAuthor);
        return "profile";
    }

   /* @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String passwordNew
    ) {
        userService.updateProfile(user, password,passwordNew);

        return "redirect:/user/profile";
    }*/

    @PostMapping("profileDeleteFav")//удаление пользователем комиксов в избранном
    public String delFav(
            @AuthenticationPrincipal User user,
            @RequestParam("f_id") Long f_id
    ) {
        favRepo.deleteById(f_id);


        return "redirect:/user/profile";
    }


}