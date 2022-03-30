package com.example.industry.service.impl;

import com.example.industry.dao.AlarmStatisticsMapper;
import com.example.industry.entity.Alarmstatistics.AlarmStatistics;
import com.example.industry.service.AlarmStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmStatisticsServiceImpl implements AlarmStatisticsService {
    @Autowired
    AlarmStatisticsMapper alarmStatisticsMapper;

    @Override
    public List<AlarmStatistics> getallstatistics(String date){return alarmStatisticsMapper.getallstatistics(date);}

    @Override
    public List<AlarmStatistics> getDevicestatistics(String date,String device){return alarmStatisticsMapper.getDevicestatistics(date,device);}

}
