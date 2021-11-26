package com.example.industry.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.industry.service.userService;

@RestController
public class LoginController {
    @Autowired
    userService userService;

    @RequestMapping("/hello")
    public String test() {
        return userService.returnid().getUsername();
    }

}
