package com.example.industry.controller;


import com.example.industry.entity.Device.OP50Current;
import com.example.industry.entity.Device.OP60Current;
import com.example.industry.entity.Device.OP70Current;
import com.example.industry.service.OP40CurrentService;
import com.example.industry.entity.Device.OP40Current;
import com.example.industry.service.OP50CurrentService;
import com.example.industry.service.OP60CurrentService;
import com.example.industry.service.OP70CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Controller
public class RealTimeController {

    @Autowired
    OP40CurrentService OP40CurrentService;

    @Autowired
    OP50CurrentService OP50CurrentService;

    @Autowired
    OP60CurrentService OP60CurrentService;

    @Autowired
    OP70CurrentService OP70CurrentService;



    @RequestMapping("/OP40")
    @ResponseBody
    public List<OP40Current> OP40(){
        List<OP40Current> realTime_OP40 = OP40CurrentService.getLatest10();
        Collections.reverse(realTime_OP40); //逆转顺序
        return realTime_OP40;
    }

    @RequestMapping("/OP50")
    @ResponseBody
    public List<OP50Current> OP50(){
        List<OP50Current> realTime_OP50 = OP50CurrentService.getLatest10();
        Collections.reverse(realTime_OP50); //逆转顺序
        return realTime_OP50;
    }

    @RequestMapping("/OP60")
    @ResponseBody
    public List<OP60Current> OP60(){
        List<OP60Current> realTime_OP60 = OP60CurrentService.getLatest10();
        Collections.reverse(realTime_OP60); //逆转顺序
        return realTime_OP60;
    }

    @RequestMapping("/OP70")
    @ResponseBody
    public List<OP70Current> OP70(){
        List<OP70Current> realTime_OP70 = OP70CurrentService.getLatest10();
        Collections.reverse(realTime_OP70); //逆转顺序
        return realTime_OP70;
    }
}
