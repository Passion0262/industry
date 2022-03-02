package com.example.industry.controller;


import com.example.industry.entity.User.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.industry.service.userService;

@Controller
public class LoginController {

    @RequestMapping("/hello")
    public String test2() {
        return "index";
    }

}
