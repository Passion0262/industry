package com.example.industry.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String showHome(HttpSession session) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登陆用户：" + name);
        session.setAttribute("username",name); //登录用户名存入session

        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        session.setAttribute("loginTime",df.format(day)); //登录时间存入session
        session.setAttribute("loginTimestamp",day.getTime()); //登录时间戳存入session

        return "redirect:/main";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }
}
