package com.example.industry.controller;


import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Outputstatistics.OutputStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
public class OutputAnalysisController {
    @Autowired
    com.example.industry.service.OutputStatisticsService OutputStatisticsService;

    @RequestMapping("/OutputAnalysis")
    @ResponseBody
    public List<OutputStatistics> OutputAnalysis(){
        List<OutputStatistics> outputStatistics = OutputStatisticsService.listAll();

        return outputStatistics.subList(outputStatistics.size()-50, outputStatistics.size());
    }
}
