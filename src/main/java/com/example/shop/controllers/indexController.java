package com.example.shop.controllers;


import com.example.shop.object.User;
import com.example.shop.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String index(Model model){
        return "index";
    }
}
