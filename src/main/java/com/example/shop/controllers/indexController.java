package com.example.shop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping(value = "/")
    public String index(Model model){

        return "index";
    }
}
