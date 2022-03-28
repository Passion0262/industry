package com.example.industry.service.impl;


import com.example.industry.dao.OutputStatisticsMapper;
import com.example.industry.entity.Outputstatistics.OutputStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.industry.service.OutputStatisticsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutputStatisticsServiceImpl implements OutputStatisticsService {
    @Autowired
    OutputStatisticsMapper outputStatisticsMapper;

    @Override
    public List<OutputStatistics> listAll(){
        return outputStatisticsMapper.listAll();
    }

    @Override
    public List<OutputStatistics> getByDate(String date){
        return outputStatisticsMapper.getByDate(date);
    }

    @Override
    public List<OutputStatistics> getByDeviceName(String deviceName){
        return outputStatisticsMapper.getByDeviceName(deviceName);
    }

}
