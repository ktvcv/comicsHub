package com.example.demo.controllers;


import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repos.UserRepo;
import com.example.demo.service.UserService;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminUserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String userList(Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("{user}")//администатор может сделать пользователя админом
    public String userEditForm(@PathVariable User user, Model model) {
        Set<Role> roles = new TreeSet<>();
        roles.add(Role.USER);//роли пользователей возможные
        roles.add(Role.ADMIN);

        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        userService.saveUser(user,username,form);

        return "redirect:/admin/user";

    }
}
