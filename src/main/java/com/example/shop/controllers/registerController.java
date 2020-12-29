package com.example.shop.controllers;

import com.example.shop.object.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class registerController {
    @PostMapping(value = "/register")
    public String postRegister(@ModelAttribute("user") User user){
        return "register";
    }

    @GetMapping(value = "/register")
    public String getRegister(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
}
