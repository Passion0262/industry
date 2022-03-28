package com.example.industry.service;

import com.example.industry.entity.Timeanalysis.TimeAnalysis;

import java.util.List;

public interface TimeAnalysisService {

    /**
     *
     * 查询所有信息
     */
    List<TimeAnalysis> listAll();

    /**
     * 根据设备名查询
     */
    List<TimeAnalysis> getByDevice(String device);

    /**
     * 根据日期查询
     */
    List<TimeAnalysis> getByDate(String date);
}
