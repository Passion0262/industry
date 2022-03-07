package com.example.industry.controller;

import com.example.industry.entity.ProductionLine;
import com.example.industry.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class toPageController {
    @Autowired
    ProductionLineService ProductionLineService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/ChanLiang")
    public String ChanLiang(){
        return "ChanLiang";
    }

    @RequestMapping("/ChanPin")
    public String ChanPin(){
        return "CHanPin";
    }

    @RequestMapping("/JiaDongLv")
    public String JiaDongLv(){
        return "JiaDongLv";
    }

    @RequestMapping("/kanban-baojingjilu")
    public String kanban_baojingjilu(){
        return "kanban-baojingjilu";
    }

    @RequestMapping("/kanban-shebeichanliangjishu")
    public String kanban_shebeichanliangjishu(){
        return "kanban-shebeichanliangjishu";
    }

    @RequestMapping("/kanban-shebeiguochengcanshu")
    public String kanban_shebeiguochengcanshu(){
        return "kanban-shebeiguochengcanshu";
    }

    @RequestMapping("/knifes")
    public String knifes(){
        return "knifes";
    }

    @RequestMapping("/knifes-huizong")
    public String knifes_huizong(){
        return "knifes-huizong";
    }

    @RequestMapping("/LiYongLv")
    public String LiYongLv(){
        return "LiYongLv";
    }

    @RequestMapping("/OEE")
    public String OEE(){
        return "OEE";
    }

    @RequestMapping("/OEE1")
    public String OEE1(){
        return "OEE1";
    }

    @RequestMapping("/production_line")
    public String production_line(){
        return "production_line";
    }

    @RequestMapping("/ZhuangTaiChaKan")
    public String ZhuangTaiChaKan(Model model){
        List<ProductionLine> productionLines = ProductionLineService.listLines();
        model.addAttribute("data", productionLines);
        return "ZhuangTaiChaKan";
    }

    @RequestMapping("/ZhuantTaiFenBu")
    public String ZhuangTaiFenBu(){
        return "ZhuangTaiFenBu";
    }
}
