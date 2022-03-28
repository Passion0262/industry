package com.example.industry.service;

import com.example.industry.entity.Outputstatistics.OutputStatistics;

import java.util.List;

public interface OutputStatisticsService {

    /**
     * 显示所有信息
     */
    List<OutputStatistics> listAll();

    /**
     * 根据日期查询
     */
    List<OutputStatistics> getByDate(String date);

    /**
     * 根据设备名称查询
     */
    List<OutputStatistics> getByDeviceName(String deviceName);
}
