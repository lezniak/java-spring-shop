package com.example.shop.controllers;
import javax.servlet.http.HttpSession;
import com.example.shop.object.User;
import com.example.shop.object.login;
import com.example.shop.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"loggedName"})
public class loginController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login")
    public String postLogin(Model model, @ModelAttribute("login") login login, HttpSession session){
        System.out.println(login.getUserName());
        System.out.println(login.getPassword());
        if (findUser(login,session)){
            return "redirect:/user_page";
        }else{
            model.addAttribute("error","error");
            return "login";
        }
    }

    @GetMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("login",new login());
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout(Model model, HttpSession session, SessionStatus status){
       session.invalidate();
        status.setComplete();
        return "redirect:/";
    }
    public boolean findUser(login login,HttpSession session){
        String userLogin = login.getUserName();
        String userPassword = login.getPassword();

        List<User> user = new ArrayList<>();
        userRepository.findAll().forEach(user::add);

        for (int i = 0; i < user.size(); i++){
            if(user.get(i).getUserName().equals(userLogin)){
                if(user.get(i).getUserPassword().equals(userPassword)){
                    session.setAttribute("loggedUser",user.get(i));
                    return true;
                }
            }
        }
        return false;
    }
}
