package com.example.industry.service;

import com.example.industry.entity.Alarmstatistics.AlarmStatistics;

import java.util.List;

public interface AlarmStatisticsService {

    //按统计日期查询各设备报警信息
    List<AlarmStatistics> getallstatistics(String date);

    //查询某一日期下某台设备的报警信息
    List<AlarmStatistics> getDevicestatistics(String date,String device);
}
