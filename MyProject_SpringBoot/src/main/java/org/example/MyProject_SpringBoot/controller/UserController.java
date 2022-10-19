package org.example.MyProject_SpringBoot.controller;

import org.example.MyProject_SpringBoot.model.User;
import org.example.MyProject_SpringBoot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUser(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("user", userList);
        return "user";
    }
    @GetMapping("/registration")
    public String addUser(Model model) {

        User user = new User();
        model.addAttribute("newUser", user);

        return "registration";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("newUser", user);

        return "registration";
    }

    @PostMapping()
    public String create(@ModelAttribute("newUser")User user) {

        userService.addUser(user);

        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){

        userService.removeUser(id);

        return "redirect:/user";
    }
}
