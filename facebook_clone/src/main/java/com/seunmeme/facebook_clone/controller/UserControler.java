package com.seunmeme.facebook_clone.controller;

import com.seunmeme.facebook_clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserControler {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }
}
