package com.example.industry.service.impl;

import com.example.industry.dao.TimeAnalysisMapper;
import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import com.example.industry.service.TimeAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeAnalysisServiceImpl implements TimeAnalysisService{

    @Autowired
    TimeAnalysisMapper timeAnalysisMapper;

    @Override
    public List<TimeAnalysis> listAll() {
        return timeAnalysisMapper.listAll();
    }

    @Override
    public List<TimeAnalysis> listByDevice(String deviceName) {
        return timeAnalysisMapper.getByDevice(deviceName);
    }

    @Override
    public List<TimeAnalysis> listByDate(String date){
        return timeAnalysisMapper.getByDate(date);
    }
}
