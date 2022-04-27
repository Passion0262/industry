package com.example.industry.controller;


import com.example.industry.entity.Cutter.cutter;
import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import com.example.industry.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class searchController {

    @Autowired
    cutterService cutterService;

//    根据刀具型号查找
    @GetMapping("/byCutterType")
    public String byCutterType(){
//        System.out.println("进入第一个byCutterType");
        return "searchPage/byCutterType";}

    @PostMapping("/byCutterType")
    public String byCutterType(String cutter_type, Model model){
//        System.out.println("进入第二个byCutterType；cutterType:"+cutter_type);
        List<cutter> cutterLists1 = cutterService.getByType(cutter_type);
        model.addAttribute("cutterLists1",cutterLists1);
        return "searchPage/cutterShow";
    }

    //    根据刀具类型查找
    @GetMapping("/byCutterCategory")
    public String byCutterType1(){return "searchPage/byCutterCategory";}

    @PostMapping("/byCutterCategory")
    public String byCutterType1(String cutter_category, Model model){
//        System.out.println("进入第二个byCutterCategory；cutterCategory:"+cutter_category);
        List<cutter> cutterLists1 = cutterService.getByCategory(cutter_category);
        for (cutter cutter : cutterLists1) {
            System.out.println(cutter);
        }

        model.addAttribute("cutterLists1",cutterLists1);

        return "searchPage/cutterShow";
    }

    //    根据设备编号查找
    @GetMapping("/byDeviceId")
    public String byCutterType2(){return "searchPage/byDeviceId";}

    @PostMapping("/byDeviceId")
    public String byCutterType2(int device_id, Model model){
        List<cutter> cutterLists1 = cutterService.getByDeviceId(device_id);
        model.addAttribute("cutterLists1",cutterLists1);
        return "searchPage/cutterShow";
    }

    //    根据刀具刀位查找
    @GetMapping("/byCutterLocation")
    public String byCutterType3(){return "searchPage/byCutterLocation";}

    @PostMapping("/byCutterLocation")
    public String byCutterType3(int cutter_location, Model model){
        List<cutter> cutterLists1 = cutterService.getByLocation(cutter_location);
        model.addAttribute("cutterLists1",cutterLists1);
        return "searchPage/cutterShow";
    }

    //    根据刀具型号查找
    @GetMapping("/byLifeState")
    public String byCutterType4(){return "searchPage/byLifeState";}

    @PostMapping("/byLifeState")
    public String byCutterType4(String life_state, Model model){
        List<cutter> cutterLists1 = cutterService.getByLifeState(life_state);
        model.addAttribute("cutterLists1",cutterLists1);
        return "searchPage/cutterShow";
    }




}
