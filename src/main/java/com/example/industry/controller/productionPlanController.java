package com.example.industry.controller;

import com.example.industry.entity.Productionplan.productionplan;
import com.example.industry.service.productionplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class productionPlanController {
    @Autowired productionplanService productionplanService;

    @RequestMapping("/productionplan")
    public String productionplan(Model model, @RequestParam Map<String, String> map){
        List<productionplan> planList = new ArrayList<productionplan>();
        if (map.isEmpty()){ //查询所有记录
            System.out.println("参数为空");
            planList = productionplanService.getall();
        }
        else{ //按照日期查询
            System.out.println(map);
            //######################时间格式修改###########################
            map.put("startTime", map.get("startTime").replaceAll("/", "-"));
            map.put("startTime", map.get("startTime").replaceAll("T", " "));
            map.put("startTime", map.get("startTime")+":00");
            map.put("endTime", map.get("endTime").replaceAll("/", "-"));
            map.put("endTime", map.get("endTime").replaceAll("T", " "));
            map.put("endTime", map.get("endTime")+":00");
            //###########################################################
            planList = productionplanService.getplans(Timestamp.valueOf(map.get("startTime")),Timestamp.valueOf(map.get("endTime")));
        }
        model.addAttribute("planList", planList);
        return "productionplan";
    }

//    @RequestMapping("/selectByTime")
//    public String selectByTime(Map<String,>)

    @RequestMapping("/addPlan")
    public String addPlan(){
        return "/addPlan";
    }

    @RequestMapping("/submitPlan")
    public String addPlan(@RequestParam Map<String, String> map) throws Exception{
//        System.out.println("进入productionplan方法了！");
//        System.out.println(map);
        productionplan productionplan= new productionplan();

//        System.out.println(map.get("planName"));
//        System.out.println(map.get("modelType"));
//        System.out.println(map.get("planYield"));
//        System.out.println(map.get("devicegroup"));
        //######################时间格式修改###########################
        map.put("plannedstart", map.get("plannedstart").replaceAll("/", "-"));
        map.put("plannedstart", map.get("plannedstart").replaceAll("T", " "));
        map.put("plannedstart", map.get("plannedstart")+":00");
        map.put("plannedend", map.get("plannedend").replaceAll("/", "-"));
        map.put("plannedend", map.get("plannedend").replaceAll("T", " "));
        map.put("plannedend", map.get("plannedend")+":00");
        //###########################################################
//        System.out.println(Timestamp.valueOf(map.get("plannedstart")));
//        System.out.println(Timestamp.valueOf(map.get("plannedend")));
        productionplan.setPlanName(map.get("planName"));
        productionplan.setModelType(Integer.parseInt(map.get("modelType")));
        productionplan.setPlanYield(Integer.parseInt(map.get("planYield")));
        productionplan.setDevicegroup(map.get("devicegroup"));
        productionplan.setPlannedstart(Timestamp.valueOf(map.get("plannedstart")));
        productionplan.setPlannedend(Timestamp.valueOf(map.get("plannedend")));

        boolean insert = productionplanService.insertproductionplan(productionplan);
        if(insert){
            System.out.println("插入成功："+ productionplan);
        }else{
            System.out.println("插入失败");
        }
        return "redirect:/productionplan";//插入失败重定向展示页面
    }
}
