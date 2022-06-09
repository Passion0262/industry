package com.example.industry.controller;

import com.example.industry.entity.Cutter.cutter;
import com.example.industry.entity.Productionplan.productionplan;
import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import com.example.industry.entity.Warn.warn;
import com.example.industry.service.*;
import com.example.industry.entity.Device.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Timestamp;

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


    @Autowired
    TimeAnalysisService TimeAnalysis;


    //主页
    @RequestMapping("/main")
    public String index1(Model model){
        List<TimeAnalysis> dataByTime = TimeAnalysis.listByDate("2022-03-11");
        model.addAttribute("dataByTime", dataByTime);

        List<warn> warnList = WarnService.listwarn();


        int sumSet = 0;
        int sumOff = 0;
        int sumOperate = 0;
        int sumStop = 0;
        int sumFree = 0;

        for (warn warn : warnList) {
            if("设定".equals(warn.getDeviceStatus())){
                sumSet++;
            }else if ("离线".equals(warn.getDeviceStatus())){
                sumOff++;
            }else if ("运行".equals(warn.getDeviceStatus())){
                sumOperate++;
            }else if ("停机".equals(warn.getDeviceStatus())){
                sumStop++;
            }else if ("空闲".equals(warn.getDeviceStatus())){
                sumFree++;
            }
        }
        model.addAttribute("sumSet",sumSet);
        model.addAttribute("sumOff",sumOff);
        model.addAttribute("sumOperate",sumOperate);
        model.addAttribute("sumStop",sumStop);
        model.addAttribute("sumFree",sumFree);

        return "index";
    }


//-----------------设备状态看板-------------------
    //即时状态查看
    @RequestMapping("/instance_status")
    public String instanceStatus(Model model){
        List<Device> productionLines = DeviceService.listDevices();
        model.addAttribute("data", productionLines);
        return "instanceStatus";
    }

    //报警记录分析
    @RequestMapping("/alarm_record")
    public String alarmRecord(Model model) throws ParseException {
        List<warn> warnlists = WarnService.listwarn();
        model.addAttribute("lists", warnlists);

        List<String> status_OP40  = Arrays.asList("设定", "bg-primary", "dripicons-code"); //[状态， 对应的颜色， 对应的图标]
        List<String> status_OP50  = Arrays.asList("设定", "bg-primary", "dripicons-code");
        List<String> status_OP60  = Arrays.asList("设定", "bg-primary", "dripicons-code");
        List<String> status_OP70  = Arrays.asList("设定", "bg-primary", "dripicons-code");
        List<String> status_PLC1  = Arrays.asList("设定", "bg-primary", "dripicons-code");
        List<String> status_PLC2  = Arrays.asList("设定", "bg-primary", "dripicons-code");
        List<String> status_measure  = Arrays.asList("设定", "bg-primary", "dripicons-code");
        List<String> status_target  = Arrays.asList("设定", "bg-primary", "dripicons-code");

        //获取设备状态
        for (warn warnlist : warnlists) {
            if ("OP40-车床".equals(warnlist.getDeviceName())){
                status_OP40.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_OP40.set(1, "bg-warning"); status_OP40.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_OP40.set(1, "bg-primary"); status_OP40.set(2, "dripicons-code"); break;
                    case "停机": status_OP40.set(1, "bg-danger"); status_OP40.set(2, "dripicons-wrong"); break;
                    case "运行": status_OP40.set(1, "bg-success"); status_OP40.set(2, "mdi-recycle-variant"); break;
                    case "离线": status_OP40.set(1, "bg-secondary"); status_OP40.set(2, "ri-wifi-off-fill"); break;
//                    default:  status_OP40.set(1, "bg-primary"); status_OP40.set(2, "mdi-check-all");
                }
            }
            if ("OP50-车床".equals(warnlist.getDeviceName())){
                status_OP50.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_OP50.set(1, "bg-warning"); status_OP50.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_OP50.set(1, "bg-primary"); status_OP50.set(2, "dripicons-code"); break;
                    case "停机": status_OP50.set(1, "bg-danger"); status_OP50.set(2, "dripicons-wrong"); break;
                    case "运行": status_OP50.set(1, "bg-success"); status_OP50.set(2, "mdi-recycle-variant"); break;
                    case "离线": status_OP50.set(1, "bg-secondary"); status_OP50.set(2, "ri-wifi-off-fill"); break;
//                  default:  status_OP50.set(1, "bg-primary"); status_OP50.set(2, "mdi-check-all"); //运行
                }
            }
            if ("OP60-立加".equals(warnlist.getDeviceName())){
                status_OP60.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_OP60.set(1, "bg-warning"); status_OP60.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_OP60.set(1, "bg-primary"); status_OP60.set(2, "dripicons-code"); break;
                    case "停机": status_OP60.set(1, "bg-danger"); status_OP60.set(2, "dripicons-wrong"); break;
                    case "运行": status_OP60.set(1, "bg-success"); status_OP60.set(2, "mdi-recycle-variant"); break;
                    case "离线": status_OP60.set(1, "bg-secondary"); status_OP60.set(2, "ri-wifi-off-fill"); break;
//                  default:  status_OP60.set(1, "bg-primary"); status_OP60.set(2, "mdi-check-all"); //运行
                }
            }
            if ("OP70-立加".equals(warnlist.getDeviceName())){
                status_OP70.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_OP70.set(1, "bg-warning"); status_OP70.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_OP70.set(1, "bg-primary"); status_OP70.set(2, "dripicons-code"); break;
                    case "停机": status_OP70.set(1, "bg-danger"); status_OP70.set(2, "dripicons-wrong"); break;
                    case "运行": status_OP70.set(1, "bg-success"); status_OP70.set(2, "mdi-recycle-variant"); break;
                    case "离线": status_OP70.set(1, "bg-secondary"); status_OP70.set(2, "ri-wifi-off-fill"); break;
//                  default:  status_OP70.set(1, "bg-primary"); status_OP70.set(2, "mdi-check-all"); //运行
                }
            }
            if ("总控PLC-1".equals(warnlist.getDeviceName())){
                status_PLC1.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_PLC1.set(1, "bg-warning"); status_PLC1.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_PLC1.set(1, "bg-primary"); status_PLC1.set(2, "dripicons-code"); break;
                    case "停机": status_PLC1.set(1, "bg-danger"); status_PLC1.set(2, "dripicons-wrong"); break;
                    case "运行": status_PLC1.set(1, "bg-success"); status_PLC1.set(2, "mdi-recycle-variant"); break;
                    case "离线": status_PLC1.set(1, "bg-secondary"); status_PLC1.set(2, "ri-wifi-off-fill"); break;
//                  default:  status_PLC1.set(1, "bg-primary"); status_PLC1.set(2, "mdi-check-all"); //运行
                }
            }
            if ("总控PLC-2".equals(warnlist.getDeviceName())){
                status_PLC2.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_PLC2.set(1, "bg-warning"); status_PLC2.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_PLC2.set(1, "bg-primary"); status_PLC2.set(2, "dripicons-code"); break;
                    case "停机": status_PLC2.set(1, "bg-danger"); status_PLC2.set(2, "dripicons-wrong"); break;
                    case "运行": status_PLC2.set(1, "bg-success"); status_PLC2.set(2, "mdi-recycle-variant"); break;
                    case "离线": status_PLC2.set(1, "bg-secondary"); status_PLC2.set(2, "ri-wifi-off-fill"); break;
//                  default:  status_PLC2.set(1, "bg-primary"); status_PLC2.set(2, "mdi-check-all"); //运行
                }
            }
            if ("测量机".equals(warnlist.getDeviceName())){
                status_measure.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_measure.set(1, "bg-warning"); status_measure.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_measure.set(1, "bg-primary"); status_measure.set(2, "dripicons-code"); break;
                    case "停机": status_measure.set(1, "bg-danger"); status_measure.set(2, "dripicons-wrong"); break;
                    case "运行": status_measure.set(1, "bg-success"); status_measure.set(2, "mdi-recycle-variant"); break;
                    case "离线": status_measure.set(1, "bg-secondary"); status_measure.set(2, "ri-wifi-off-fill"); break;
//                  default:  status_measure.set(1, "bg-primary"); status_measure.set(2, "mdi-check-all"); //运行
                }
            }
            if ("打标机".equals(warnlist.getDeviceName())){
                status_target.set(0, warnlist.getDeviceStatus());
                switch(warnlist.getDeviceStatus()){
                    case "空闲": status_target.set(1, "bg-warning"); status_target.set(2, "dripicons-time-reverse"); break;
                    case "设定": status_target.set(1, "bg-primary"); status_target.set(2, "dripicons-code"); break;
                    case "停机": status_target.set(1, "bg-danger"); status_target.set(2, "dripicons-wrong"); break;
                    case "运行": status_target.set(1, "bg-success"); status_target.set(2, "mdi-recycle-variant"); break;
                    case "离线": status_target.set(1, "bg-secondary"); status_target.set(2, "ri-wifi-off-fill"); break;
//                  default:  status_target.set(1, "bg-primary"); status_target.set(2, "mdi-check-all"); //运行
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



        return "alarmRecord";
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

    //设备过程参数
    @RequestMapping("/device_parameter")
    public String deviceParameter(){
        return "deviceParameter";
    }
//-------------------------------------------------------


//-----------------产量分析看板-----------------
//    //产量数据
//    @RequestMapping("/output")
//    public String ChanLiang(){
//        return "ChanLiang";
//    }
//
//    //产品信息
//    @RequestMapping("/pruduct_information")
//    public String ChanPin(){
//        return "ChanPin";
//    }

    //----------------------用时分析bar---------   ----------------
    @RequestMapping("/time_analysis")
    public String timeAnalysis(String data, Model model){
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
        return "timeAnalysis";
    }

    //----------------------用时分析table---------   ----------------
    @RequestMapping("/time_analysisT")
    public String timeAnalysisT(String data, Model model){
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

        return "timeAnalysisT";
    }

    //设备产量计数分析
    @RequestMapping("/count_analysis")
    public String outputAnalysis(){
        return "outputAnalysis";
    }
//-------------------------------------------


//状态分布看板
    @RequestMapping("/status_distribute")
    public String statusDistribute(){
        return "statusDistribute";
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
    public String cutter(Model model) {
        List<cutter> cutterList = cutterService.listCutter();
        model.addAttribute("cutterList", cutterList);

        List<String> warnings = new ArrayList<>();//保存警告刀具id
        List<String> aralms = new ArrayList<>();//保存报警刀具id

        int sum_warnings = 0;//警告刀具数量
        int sum_aralms = 0;//报警刀具数量

        for (cutter cutter : cutterList) {
            if(cutter.getLifeState().equals("警告")){
                sum_warnings++;
                warnings.add(String.valueOf(cutter.getCutterId()));
            }else if(cutter.getLifeState().equals("报警")){
                sum_aralms++;
                aralms.add(String.valueOf(cutter.getCutterId()));
            }
        }

        model.addAttribute("warnings", warnings);
        model.addAttribute("aralms", aralms);
        model.addAttribute("sum_warnings", sum_warnings);
        model.addAttribute("sum_aralms", sum_aralms);

        return "cutter";
    }

    //刀具汇总查询
    @RequestMapping("/cutter_all")
    public String knifes_huizong(){
        return "knifes-huizong";
    }
//-------------------------------------------




    //----------------增加刀具-----------------
    @GetMapping("/addCutter")
    public String addCutter(Model model) {
        List<cutter> cutterList = cutterService.listCutter();
        int lastNumber = cutterList.get(cutterList.size()-1).getCutterId()+1;

        model.addAttribute("number",lastNumber);
        return "addCutter";
    }

    @PostMapping("/addCutter")
    public String addCutter(cutter cutter) {
//        System.out.println("进入第二个addCutter1方法了！");
        boolean insert = cutterService.insertCutter(cutter);
        if(insert){
            System.out.println("插入成功："+cutter);
        }else{
            System.out.println("插入失败");
        }
        return "redirect:/cutter";//重定向展示页面
    }

    @RequestMapping("/deleteCutter/{cutterId}")
    public String deleteCutter(@PathVariable("cutterId") int cutterId) {
        System.out.println("进入deleteCutter方法！");
        boolean delete = cutterService.deleteById(cutterId);
        if(delete){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        return "redirect:/cutter";//重定向展示页面
    }
//----------------------生产计划-------------------------
    //转至productionPlanController

    //----------------------test-----------------------
    @RequestMapping("/test")
    public String test(){
        return "test";
    }


    public static long strToDate(String time) {
        Date newTime=new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 字符串转换成时间
        try {
            newTime = sd.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  newTime.getTime();
    }
}
