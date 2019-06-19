package com.example.demo.controllers;


import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repos.UserRepo;
import com.example.demo.service.UserService;
import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.Map;
//регистрация пользователей
@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (user.getPassword() != null) {
            model.addAttribute("passwordError", "Passwords are different!");
        }

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "Пользователь уже существует");
            return "registration";
        }

        return "redirect:/login";
    }
            }

