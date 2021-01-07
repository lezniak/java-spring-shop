package com.example.shop.controllers;

import com.example.shop.object.User;
import com.example.shop.object.item;
import com.example.shop.respositories.UserRepository;
import com.example.shop.respositories.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class profileController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private itemRepository itemRepository;
    @RequestMapping(value = "/user/{id}")
    public String userprofileRequest (
            @PathVariable("id") int idLink, Model model) {
        List<User> user = new ArrayList<>();
        userRepository.findAll().forEach(user::add);

        for (int i = 0; i < user.size(); i++){
            if(user.get(i).getId().equals(idLink)) {
                model.addAttribute("user",user.get(i));

                List<item> item = new ArrayList<>();
                itemRepository.findAll().forEach(item::add);

                List<item> findList = new ArrayList<>();

                for (int z = 0; z < item.size(); z++) {
                    if(item.get(z).getWhoAdd().equals(idLink)){
                        findList.add(item.get(z));
                    }
                }
                model.addAttribute("item",findList);

                return "user";
            }
        }
        return "redirect:/";
    }
}
