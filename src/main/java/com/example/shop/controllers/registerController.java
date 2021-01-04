package com.example.shop.controllers;

import com.example.shop.object.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
@Controller
public class registerController {
    @PostMapping(value = "/register")
    public String postRegister(@ModelAttribute("user") User user){
        System.out.println(user.getUserEmail());
        return "redirect:/";
    }

    @GetMapping(value = "/register")
    public String getRegister(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
}
