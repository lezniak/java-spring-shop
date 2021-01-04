package com.example.shop.controllers;

import com.example.shop.object.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class userpageController {
    @GetMapping(value = "/user_page")
    public String userpage(Model model, @ModelAttribute("loggedName") User user ){
            return "user_page";
    }
}
