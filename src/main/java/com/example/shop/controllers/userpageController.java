package com.example.shop.controllers;

import com.example.shop.object.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class userpageController {
    @GetMapping(value = "/user_page")
    public String userpage(Model model,HttpServletRequest request, HttpSession session){

        User isExist= (User) session.getAttribute("loggedUser");

            if (null == isExist){
                return "redirect:/";
            }else{
                return "user_page";
            }

    }
}
