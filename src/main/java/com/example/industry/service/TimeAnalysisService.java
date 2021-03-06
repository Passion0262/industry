package com.example.industry.service;

import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import com.example.industry.entity.vo.TimeAnalysisVO;

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
    List<TimeAnalysis> listByDevice(String deviceName);

    /**
     * 根据日期查询，返回当日所有设备时间占比
     */
    List<TimeAnalysis> listByDate(String date);

    /**
     *查询某时间范围内的用时分析数据
     */
    List<TimeAnalysis> listByDateRange(String start_date,String end_date);
}
