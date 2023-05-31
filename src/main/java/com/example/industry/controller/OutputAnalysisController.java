package com.example.industry.controller;


import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.entity.Device.OP60Current;
import com.example.industry.entity.Device.OP70Current;
import com.example.industry.entity.Outputstatistics.OutputStatistics;
import org.python.modules._json._json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.*;

@Controller
public class OutputAnalysisController {
    @Autowired
    com.example.industry.service.OutputStatisticsService OutputStatisticsService;
    @Autowired
    com.example.industry.service.OP40CurrentService OP40CurrentService;
    @Autowired
    com.example.industry.service.OP50CurrentService OP50CurrentService;
    @Autowired
    com.example.industry.service.OP60CurrentService OP60CurrentService;
    @Autowired
    com.example.industry.service.OP70CurrentService OP70CurrentService;




    @RequestMapping("/OutputAnalysis")
    @ResponseBody
    public Map<String, List> OutputAnalysis(){
        System.out.println("ijdffdgn");
        OP40Current op40output =  OP40CurrentService.getLatest();
        OP50Current op50output =  OP50CurrentService.getLatest();
        OP60Current op60output =  OP60CurrentService.getLatest();
        OP70Current op70output =  OP70CurrentService.getLatest();

        List<Integer> outputAnalysis = new ArrayList<>();
        outputAnalysis.add(op40output.getOutput());
        outputAnalysis.add(op50output.getOutput());
        outputAnalysis.add(op60output.getOutput());
        outputAnalysis.add(op70output.getOutput());

        List<Timestamp> outputAnalysisdate = new ArrayList<>();
        outputAnalysisdate.add(op40output.getTime());
        outputAnalysisdate.add(op50output.getTime());
        outputAnalysisdate.add(op60output.getTime());
        outputAnalysisdate.add(op70output.getTime());

        System.out.println(outputAnalysis);

        Map<String, List> map = new HashMap<String, List>();
        map.put("outputAnalysis", outputAnalysis);
        map.put("outputAnalysisdate", outputAnalysisdate);
        return map;

//        return .subList(outputStatistics.size()-50, outputStatistics.size());
//        return outputAnalysis, outputAnalysisdate;
    }
}
