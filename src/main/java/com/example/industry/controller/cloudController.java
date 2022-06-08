package com.example.industry.controller;

import com.example.industry.entity.Cutter.cutter;
import com.example.industry.entity.Productionplan.productionplan;
import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import com.example.industry.entity.Warn.warn;
import com.example.industry.service.TimeAnalysisService;
import com.example.industry.service.WarnService;
import com.example.industry.service.cutterService;
import com.example.industry.service.productionplanService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 云端
 */
@Controller
public class cloudController {
    @Autowired
    cutterService cutterService;

    @Autowired
    TimeAnalysisService TimeAnalysis;

    @Autowired
    WarnService WarnService;

    @Autowired
    com.example.industry.service.productionplanService productionplanService;

    //----------------主页-----------------
    @RequestMapping("/cloud_index")
    public String index(Model model) {
        return "cloudPages/index";
    }

    //----------------ML训练页-----------------
    @RequestMapping("/cloud_ML")
    public String ML(Model model) {
        return "cloudPages/model_select";
    }

    //----------------OEE-----------------
    @RequestMapping("/cloud_OEE")
    public String OEE(Model model) {
        return "cloudPages/OEE";
    }

    //----------------刀具信息-----------------
    @RequestMapping("/cloud_cutter")
    public String cutter(Model model) {
        List<cutter> cutterList = cutterService.listCutter();
        model.addAttribute("cutterList", cutterList);

        List<String> warnings = new ArrayList<>();//保存警告刀具id
        List<String> aralms = new ArrayList<>();//保存报警刀具id

        int sum_warnings = 0;//警告刀具数量
        int sum_aralms = 0;//报警刀具数量

        for (cutter cutter : cutterList) {
            if("警告".equals(cutter.getLifeState())){
                sum_warnings++;
                warnings.add(String.valueOf(cutter.getCutterId()));
            }else if("报警".equals(cutter.getLifeState())){
                sum_aralms++;
                aralms.add(String.valueOf(cutter.getCutterId()));
            }
        }

        model.addAttribute("warnings", warnings);
        model.addAttribute("aralms", aralms);
        model.addAttribute("sum_warnings", sum_warnings);
        model.addAttribute("sum_aralms", sum_aralms);

        return "cloudPages/cutters";
    }

    //----------------------产量分析-------------------------
    @RequestMapping("/cloud_products")
    public String timeAnalysisT(String data, Model model, @RequestParam Map<String, String> map){
        //用时分析
        if(data==null){
            data="2022-03-11"; //默认展示 2022-03-11 的数据
        }
        List<TimeAnalysis> dataByTime = TimeAnalysis.listByDate(data);
        //打印测试
//        System.out.println("=====================!");
//        for (TimeAnalysis timeAnalysis : dataByTime) {
//            System.out.println("data:"+timeAnalysis);
//        }
//        System.out.println("=====================!");

        model.addAttribute("dataByTime", dataByTime);

        //生产计划
        List<productionplan> planList;
        if (map.get("startTime")==null || map.get("endTime")==null || map.get("startTime")=="" || map.get("endTime")==""){ //查询所有记录
//            System.out.println("参数为空");
            planList = productionplanService.getall();
//            for (productionplan productionplan : planList) {
//                System.out.println(productionplan);
//            }
        }
        else{ //按照日期查询
//            System.out.println(map);
            //######################时间格式修改###########################
            map.put("startTime", map.get("startTime").replaceAll("/", "-"));
            map.put("startTime", map.get("startTime").replaceAll("T", " "));
            map.put("startTime", map.get("startTime")+":00");
            map.put("endTime", map.get("endTime").replaceAll("/", "-"));
            map.put("endTime", map.get("endTime").replaceAll("T", " "));
            map.put("endTime", map.get("endTime")+":00");
            //###########################################################
            System.out.println(map);
            planList = productionplanService.getplans(Timestamp.valueOf(map.get("startTime")),Timestamp.valueOf(map.get("endTime")));
        }
        model.addAttribute("planList", planList);

        return "cloudPages/products";
    }

    //----------------设备状态-----------------
    @RequestMapping("/cloud_status")
    public String status(Model model) {
        List<warn> warnList = WarnService.listwarn();

        List<String> setting = new ArrayList<>();
        List<String> off = new ArrayList<>();
        List<String> operate = new ArrayList<>();
        List<String> stop = new ArrayList<>();
        List<String> free = new ArrayList<>();

        int sumSet = 0;
        int sumOff = 0;
        int sumOperate = 0;
        int sumStop = 0;
        int sumFree = 0;

        System.out.println("-------------");int i=0;
        for (warn warn : warnList) {
            if("设定".equals(warn.getDeviceStatus())){
                String temp = warn.getDeviceName()+"(warnID: "+warn.getWarnId()+")";
                setting.add(temp);sumSet++;
            }else if ("离线".equals(warn.getDeviceStatus())){
                String temp = warn.getDeviceName()+"(warnID: "+warn.getWarnId()+")";
                off.add(temp);sumOff++;
            }else if ("运行".equals(warn.getDeviceStatus())){
                String temp = warn.getDeviceName()+"(warnID: "+warn.getWarnId()+")";
                operate.add(temp);sumOperate++;
            }else if ("停机".equals(warn.getDeviceStatus())){
                String temp = warn.getDeviceName()+"(warnID: "+warn.getWarnId()+")";
                stop.add(temp);sumStop++;
            }else if ("空闲".equals(warn.getDeviceStatus())){
                String temp = warn.getDeviceName()+"(warnID: "+warn.getWarnId()+")";
                free.add(temp);sumFree++;
            }
        }
        model.addAttribute("setting",setting);
        model.addAttribute("off",off);
        model.addAttribute("operate",operate);
        model.addAttribute("stop",stop);
        model.addAttribute("free",free);

        model.addAttribute("sumSet",sumSet);
        model.addAttribute("sumOff",sumOff);
        model.addAttribute("sumOperate",sumOperate);
        model.addAttribute("sumStop",sumStop);
        model.addAttribute("sumFree",sumFree);
        return "cloudPages/status";
    }

}
