package com.example.industry.controller;

import com.example.industry.entity.Cutter.cutter;
import com.example.industry.entity.Productionplan.productionplan;
import com.example.industry.entity.Warn.warn;
import com.example.industry.service.WarnService;
import com.example.industry.entity.Device.Device;
import com.example.industry.service.DeviceService;
import com.example.industry.service.cutterService;
import com.example.industry.service.productionplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class toPageController {
    @Autowired
    DeviceService DeviceService;

    @Autowired
    cutterService cutterService;

    @Autowired
    productionplanService productionplanService;

    @Autowired
    WarnService WarnService;

    //主页
    @RequestMapping("/main")
    public String index(){
        return "index";
    }


//-----------------设备状态看板-------------------
    //即时状态查看
    @RequestMapping("/instance_status")
    public String ZhuangTaiChaKan(Model model){
        List<Device> productionLines = DeviceService.listDevices();
        model.addAttribute("data", productionLines);
        return "ZhuangTaiChaKan";
    }

    //报警记录分析
    @RequestMapping("/alarm_record")
    public String kanban_baojingjilu(Model model){
        List<warn> warnlists = WarnService.listwarn();
        model.addAttribute("lists", warnlists);

        List<String> status_OP40  = Arrays.asList("运行", "bg-primary", "mid-check-all"); //[状态， 对应的颜色， 对应的图标]
        List<String> status_OP50  = Arrays.asList("运行", "bg-primary", "mid-check-all");
        List<String> status_OP60  = Arrays.asList("运行", "bg-primary", "mid-check-all");
        List<String> status_OP70  = Arrays.asList("运行", "bg-primary", "mid-check-all");
        List<String> status_PLC1  = Arrays.asList("运行", "bg-primary", "mid-check-all");
        List<String> status_PLC2  = Arrays.asList("运行", "bg-primary", "mid-check-all");
        List<String> status_measure  = Arrays.asList("运行", "bg-primary", "mid-check-all");
        List<String> status_target  = Arrays.asList("运行", "bg-primary", "mid-check-all");


        //获取设备状态
        for (warn warnlist : warnlists) {
            if (warnlist.getDeviceName().equals("OP40-车床")){
                status_OP40.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_OP40.set(1, "bg-secondary"); status_OP40.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_OP40.set(1, "bg-success"); status_OP40.set(2, "dripicons-code"); break;
                    case "停机": status_OP40.set(1, "bg-danger"); status_OP40.set(2, "dripicons-wrong"); break;
                    default:  status_OP40.set(1, "bg-primary"); status_OP40.set(2, "mid-check-all"); //运行
                }
            }
            if (warnlist.getDeviceName().equals("OP50-车床")){
                status_OP50.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_OP50.set(1, "bg-secondary"); status_OP50.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_OP50.set(1, "bg-success"); status_OP50.set(2, "dripicons-code"); break;
                    case "停机": status_OP50.set(1, "bg-danger"); status_OP50.set(2, "dripicons-wrong"); break;
                    default:  status_OP50.set(1, "bg-primary"); status_OP50.set(2, "mid-check-all"); //运行
                }
            }
            if (warnlist.getDeviceName().equals("OP60-立加")){
                status_OP60.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_OP60.set(1, "bg-secondary"); status_OP60.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_OP60.set(1, "bg-success"); status_OP60.set(2, "dripicons-code"); break;
                    case "停机": status_OP60.set(1, "bg-danger"); status_OP60.set(2, "dripicons-wrong"); break;
                    default:  status_OP60.set(1, "bg-primary"); status_OP60.set(2, "mid-check-all"); //运行
                }
            }
            if (warnlist.getDeviceName().equals("OP70-立加")){
                status_OP70.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_OP70.set(1, "bg-secondary"); status_OP70.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_OP70.set(1, "bg-success"); status_OP70.set(2, "dripicons-code"); break;
                    case "停机": status_OP70.set(1, "bg-danger"); status_OP70.set(2, "dripicons-wrong"); break;
                    default:  status_OP70.set(1, "bg-primary"); status_OP70.set(2, "mid-check-all"); //运行
                }
            }
            if (warnlist.getDeviceName().equals("总控PLC-1")){
                status_PLC1.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_PLC1.set(1, "bg-secondary"); status_PLC1.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_PLC1.set(1, "bg-success"); status_PLC1.set(2, "dripicons-code"); break;
                    case "停机": status_PLC1.set(1, "bg-danger"); status_PLC1.set(2, "dripicons-wrong"); break;
                    default:  status_PLC1.set(1, "bg-primary"); status_PLC1.set(2, "mid-check-all"); //运行
                }
            }
            if (warnlist.getDeviceName().equals("总控PLC-2")){
                status_PLC2.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_PLC2.set(1, "bg-secondary"); status_PLC2.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_PLC2.set(1, "bg-success"); status_PLC2.set(2, "dripicons-code"); break;
                    case "停机": status_PLC2.set(1, "bg-danger"); status_PLC2.set(2, "dripicons-wrong"); break;
                    default:  status_PLC2.set(1, "bg-primary"); status_PLC2.set(2, "mid-check-all"); //运行
                }
            }
            if (warnlist.getDeviceName().equals("测量机")){
                status_measure.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_measure.set(1, "bg-secondary"); status_measure.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_measure.set(1, "bg-success"); status_measure.set(2, "dripicons-code"); break;
                    case "停机": status_measure.set(1, "bg-danger"); status_measure.set(2, "dripicons-wrong"); break;
                    default:  status_measure.set(1, "bg-primary"); status_measure.set(2, "mid-check-all"); //运行
                }
            }
            if (warnlist.getDeviceName().equals("打标机")){
                status_target.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_target.set(1, "bg-secondary"); status_target.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_target.set(1, "bg-success"); status_target.set(2, "dripicons-code"); break;
                    case "停机": status_target.set(1, "bg-danger"); status_target.set(2, "dripicons-wrong"); break;
                    default:  status_target.set(1, "bg-primary"); status_target.set(2, "mid-check-all"); //运行
                }
            }
        }
        model.addAttribute("status_OP40", status_OP40);
        model.addAttribute("status_OP50", status_OP50);
        model.addAttribute("status_OP60", status_OP60);
        model.addAttribute("status_OP70", status_OP70);
        model.addAttribute("status_PLC1", status_PLC1);
        model.addAttribute("status_PLC2", status_PLC2);
        model.addAttribute("status_measure", status_measure);
        model.addAttribute("status_target", status_target);

        return "kanban-baojingjilu";
    }

    //设备产量计数分析
    @RequestMapping("/count_analysis")
    public String kanban_shebeichanliangjishu(){
        return "kanban-shebeichanliangjishu";
    }

    //看板-设备过程参数
    @RequestMapping("/board_deviceParameter")
    public String kanban_shebeiguochengcanshu(){
        return "kanban-shebeiguochengcanshu";
    }
//--------------------------------------------------------------------


//----------------实时数据看板---------------------
    //设备利用率
    @RequestMapping("/use_ratio")
    public String LiYongLv(){
        return "LiYongLv";
    }

    //设备稼动率
    @RequestMapping("/activation")
    public String JiaDongLv(){
        return "JiaDongLv";
    }
//-------------------------------------------------------


//-----------------产量分析看板-----------------
    //产量数据
    @RequestMapping("/output")
    public String ChanLiang(){
        return "ChanLiang";
    }

    //产品信息
    @RequestMapping("/pruduct_information")
    public String ChanPin(){
        return "ChanPin";
    }
//-------------------------------------------


//状态分布看板
    @RequestMapping("/status_distribute")
    public String ZhuangTaiFenBu(){
        return "ZhuangTaiFenBu";
    }


//-----------------OEE--------------------
    //当前设备OEE
    @RequestMapping("/OEE")
    public String OEE(){
        return "OEE";
    }

    //整线OEE
    @RequestMapping("/OEE1")
    public String OEE1(){
        return "OEE1";
    }
//---------------------------------------


//----------------刀具分析-----------------
    //全部刀具分析
    @RequestMapping("/cutter")
    public String knifes(Model model) {
        List<cutter> cutterList = cutterService.listCutter();
        model.addAttribute("cutterList", cutterList);
        return "knifes";
    }

    //刀具汇总查询
    @RequestMapping("/cutter_all")
    public String knifes_huizong(){
        return "knifes-huizong";
    }
//-------------------------------------------

//----------------------生产计划-------------------------
    @RequestMapping("/productionplan")
    public String productionplan(Model model){
        List<productionplan> planList = productionplanService.getall();
        model.addAttribute("planList", planList);
        return "productionplan";
    }

//----------------------test-----------------------
    @RequestMapping("/test")
    public String test(){
        return "test";
    }





}
