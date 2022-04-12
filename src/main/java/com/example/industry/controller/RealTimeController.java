package com.example.industry.controller;


import com.example.industry.service.OP40CurrentService;
import com.example.industry.entity.Device.OP40Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
public class RealTimeController {

    @Autowired
    OP40CurrentService OP40CurrentService;

    @RequestMapping("/OP40")
    @ResponseBody
    public List<OP40Current> OP40(){
        List<OP40Current> realTime_OP40 = OP40CurrentService.listOP40Current();
        return realTime_OP40.subList(realTime_OP40.size()-4,realTime_OP40.size()); //获取数据库末尾4条数据
    }
}
