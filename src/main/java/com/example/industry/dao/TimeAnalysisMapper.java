package com.example.industry.dao;

import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;

import  java.util.List;
@Mapper
public interface TimeAnalysisMapper {
    /**
     * 查询所有信息
     */
    @Select("SELECT * FROM time_analysis")
    List<TimeAnalysis> listAll();

    /**
     * 根据设备查询
     */
    @Select("SELECT * FROM time_analysis WHERE device=#{device}")
    List<TimeAnalysis> listByDevice(String device);

    /**
     * 获取最新的一条记录
     */
    @Select("SELECT * FROM time_analysis WHERE id = (SELECT MAX(id) FROM time_analysis)")
    TimeAnalysis getLatest();

    /**
     * 根据日期查询
     */
    @Select("SELECT * FROM time_analysis WHERE date=#{date}")
    List<TimeAnalysis> listByDate(String date);

    /**
     *查询某时间范围内的数据
     */
    @Select("SELECT * from time_analysis where date BETWEEN #{start_date} AND #{end_date}")
    List<TimeAnalysis> listByDateRange(String start_date,String end_date);

    /**
     *插入设备用时的数据
     */
    @Insert("INSERT INTO time_analysis(id,date,device,stop,operate,free,offline,setting) " +
            "VALUES (null,#{date},#{device},#{stop},#{operate},#{free},#{offline},#{setting})")
    boolean insertStatusAnalysis(TimeAnalysis timeAnalysis);

}
