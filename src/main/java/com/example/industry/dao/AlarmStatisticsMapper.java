package com.example.industry.dao;

import com.example.industry.entity.Alarmstatistics.AlarmStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AlarmStatisticsMapper {
    /**
     *按统计日期查询各设备报警信息
     */
    @Select("SELECT * from alarm_statistics where date=#{date}")
    List<AlarmStatistics> getallstatistics(String date);

    /**
     *查询某一日期下某台设备的报警信息
     */
    @Select("SELECT * from alarm_statistics where date=#{date} AND device=#{device}")
    List<AlarmStatistics> getDevicestatistics(String date,String device);

}
