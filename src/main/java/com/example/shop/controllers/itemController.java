package com.example.shop.controllers;

import com.example.shop.object.User;
import com.example.shop.object.item;
import com.example.shop.respositories.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class itemController {
    @Autowired
    private itemRepository itemRepository;
    @GetMapping(value = "/items")
    public String item(Model model, HttpSession session){

        User isExist= (User) session.getAttribute("loggedUser");
        if (null == isExist){
            return "index";
        }

        List<item> item = new ArrayList<>();
        itemRepository.findAll().forEach(item::add);

        List<item> findList = new ArrayList<item>();

        for (int i = 0; i < item.size(); i++) {
            if(item.get(i).getWhoAdd().equals(isExist.getId())){
                findList.add(item.get(i));
            }
        }
        model.addAttribute("item",findList);
        return "item";
    }

    @GetMapping(value = "/items/add")
    public String itemAdd(Model model, HttpSession session){
        User isExist= (User) session.getAttribute("loggedUser");
        if (null == isExist){
            return "index";
        }
        model.addAttribute("item", new item());
        return "itemAdd";
    }

    @PostMapping(value = "/items/add")
    public String itemAddPost(Model model, HttpSession session, @ModelAttribute("item") item item){
        User isExist= (User) session.getAttribute("loggedUser");
        if (null == isExist){
            return "index";
        }
        item.setWhoAdd(isExist.getId());
        itemRepository.save(item);
        return "redirect:/items";
    }
}
