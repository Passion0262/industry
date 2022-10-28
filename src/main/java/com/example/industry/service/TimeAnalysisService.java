package com.example.industry.service;

import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import com.example.industry.entity.vo.TimeAnalysisVO;
import org.apache.ibatis.annotations.Select;

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

    /**
     *插入设备用时的数据
     */
    boolean insertStatusAnalysis(TimeAnalysis timeAnalysis);

    /**
     * 获取最新的一条记录
     */
    TimeAnalysis getLatest();

//    /**
//     * 获取op40指定某一天的数据
//     */
//    List<OP40Current> getOP40ListByDate(String date);
}
