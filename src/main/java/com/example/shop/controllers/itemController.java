package com.example.shop.controllers;

import com.example.shop.object.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class itemController {

    @GetMapping(value = "/items")
    public String item(Model model, HttpSession session){

        User isExist= (User) session.getAttribute("loggedUser");
        if (null == isExist){
            return "index";
        }
        return "item";
    }

    @GetMapping(value = "/items/add")
    public String itemAdd(Model model, HttpSession session){
        User isExist= (User) session.getAttribute("loggedUser");
        if (null == isExist){
            return "index";
        }
        return "itemAdd";
    }
}
