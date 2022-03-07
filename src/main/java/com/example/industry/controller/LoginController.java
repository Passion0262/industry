package com.example.industry.controller;


import com.example.industry.entity.ProductionLine;
import com.example.industry.entity.User.user;
import com.example.industry.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.industry.service.userService;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    ProductionLineService ProductionLineService;

    @RequestMapping("/hello")
    public String test() {
        return "ZhuangTaiCHaKan";
    }

    @RequestMapping("/hello2")
    public String test2(Model model) throws Exception{
        List<ProductionLine> productionLines = ProductionLineService.listLines();
        model.addAttribute("data", productionLines);
        return "ZhuangTaiChaKan";
    }

    @RequestMapping("/ZhuangTaiFenBu")
    public String test3(){
        return "ZhuangTaiFenBu";
    }
}
