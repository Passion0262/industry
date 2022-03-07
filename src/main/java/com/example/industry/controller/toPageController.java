package com.example.industry.controller;

import com.example.industry.entity.Cutter.cutter;
import com.example.industry.entity.ProductionLine;
import com.example.industry.service.ProductionLineService;
import com.example.industry.service.cutterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class toPageController {
    @Autowired
    ProductionLineService ProductionLineService;

    @Autowired
    cutterService cutterService;

    //主页
    @RequestMapping("/main")
    public String index(){
        return "index";
    }


//-----------------设备状态看板-------------------
    //即时状态查看
    @RequestMapping("/instance_status")
    public String ZhuangTaiChaKan(Model model){
        List<ProductionLine> productionLines = ProductionLineService.listLines();
        model.addAttribute("data", productionLines);
        return "ZhuangTaiChaKan";
    }

    //报警记录分析
    @RequestMapping("/alarm_record")
    public String kanban_baojingjilu(){
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





}
